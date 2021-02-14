package com.shu.copartner.controller.vipbercontroller;

import com.shu.copartner.exceptions.BusinessException;
import com.shu.copartner.exceptions.Exceptions;
import com.shu.copartner.mapper.ProUserMapper;
import com.shu.copartner.pojo.ProUser;
import com.shu.copartner.pojo.ProUserExample;
import com.shu.copartner.pojo.request.ProjectApplyVO;
import com.shu.copartner.pojo.request.PublicRegistryInfoVO;
import com.shu.copartner.service.FileuploadService;
import com.shu.copartner.service.VipUserService;
import com.shu.copartner.utils.constance.Constants;
import com.shu.copartner.utils.fastdfs.FastDfsClient;
import com.shu.copartner.utils.returnobj.TableModel;
import lombok.extern.slf4j.Slf4j;
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.testng.annotations.Test;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

/**
 * @author
 * @date 2021/2/1 16:19
 * @description
 */
@Slf4j
@RestController
@RequestMapping("vip/user")
@CrossOrigin
public class VipUserController {

    @Autowired
    private VipUserService vipUserService;

    @Autowired
    private FileuploadService fileuploadService;

    @Autowired
    private ProUserMapper proUserMapper;

    /**
     * 查询我的信息
     * @param principal
     * @return
     */
    @GetMapping(value = "selectPersonalInfo")
    public TableModel selectPersonalInfo(Principal principal) {
        return vipUserService.selectPersonalInfo(principal.getName());
    }

    /**
     * 个人信息修改
     * @param publicRegistryInfoVO
     * @param result
     * @return
     */
    @PostMapping("updatePersonalInfo")
    public TableModel updatePersonalInfo(@RequestBody @Valid PublicRegistryInfoVO publicRegistryInfoVO, BindingResult result) {
        if (result.hasErrors()) {
            log.error(result.getAllErrors().toString());
            throw new BusinessException(Exceptions.SERVER_PARAMSETTING_ERROR.getEcode());
        }
        return vipUserService.updatePersonalInfo(publicRegistryInfoVO);
    }

    /**
     * 上传个人头像
     * @param file
     * @return
     */
    @PostMapping(value = "uploadPersonalImage")
    public TableModel uploadPersonalImage(MultipartFile file,Principal principal) throws IOException, MyException {
        return fileuploadService.uploadPersonalImage(file,principal.getName());
    }

    /**
     * 修改手机号
     * @param newPhone
     * @param principal
     * @return
     */
    @GetMapping(value = "handleUpdatePhone")
    public TableModel handleUpdatePhone(@Size(min = 11) @RequestParam String newPhone,Principal principal) {
        return vipUserService.handleUpdatePhone(newPhone,principal.getName());
    }

}
