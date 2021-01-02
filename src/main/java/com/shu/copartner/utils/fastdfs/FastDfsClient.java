package com.shu.copartner.utils.fastdfs;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.*;

/**
 * @author cxy
 */
@Slf4j
public class FastDfsClient {
    private static StorageClient1 storageClient1 = null;

    static {
        try {
            // 获取配置文件
            String classPath = new File(FastDfsClient.class.getResource("/").getFile()).getCanonicalPath();
            String CONF_FILENAME = classPath + File.separator + "conf" + File.separator + "fdfs_client.conf";
            ClientGlobal.init(CONF_FILENAME);
            // 获取触发器
            TrackerClient trackerClient = new TrackerClient(ClientGlobal.g_tracker_group);
            TrackerServer trackerServer = trackerClient.getConnection();
            // 获取存储服务器
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            storageClient1 = new StorageClient1(trackerServer, storageServer);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * @param fis      文件输入流
     * @param fileName 文件名称
     * @return
     */
    public static String uploadFile(InputStream fis, String fileName) {
        try {
            NameValuePair[] meta_list = null;

            //将输入流写入file_buff数组
            byte[] file_buff = null;
            if (fis != null) {
                int len = fis.available();
                file_buff = new byte[len];
                fis.read(file_buff);
            }
            String fileid = storageClient1.upload_file1(file_buff, getFileExt(fileName), meta_list);
            return fileid;
        } catch (Exception ex) {
            return null;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }


    private static String getFileExt(String fileName) {
        if (StringUtils.isBlank(fileName) || !fileName.contains(".")) {
            return "";
        } else {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
    }


    /**
     * 从FastDFS删除文件
     *
     * @param groupName      文件在FastDFS中的组名
     * @param remoteFilename 文件在FastDFS中的名称
     */
    public static boolean deleteFile(String groupName, String remoteFilename) {
        try {
            int i = storageClient1.delete_file(groupName, remoteFilename);
        } catch (IOException | MyException e) {
            log.error("error", e);
            return false;
        }
        return true;
    }


    public static void downloadFile(String localFilename, String groupName, String remoteFilename) {
        File file = new File(localFilename);
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {
            byte[] content = storageClient1.download_file(groupName, remoteFilename);
            if (content == null || content.length == 0) {
                boolean flag = file.delete();
                return;
            }
            bos.write(content);
        } catch (IOException | MyException ignored) {
        }
    }
}

