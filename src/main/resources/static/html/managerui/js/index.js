$(document).ready(function(){	
	$('.zh_con1:gt(0)').hide();	
	 var hdw = $('.rh_zhtab ul li');	
	hdw.click(function(){		
		$(this).addClass('zh_li').siblings().removeClass();		
		var hdw_index = hdw.index(this);		
		$('.zh_con1').eq(hdw.index(this)).show().siblings().hide();			
	});
});