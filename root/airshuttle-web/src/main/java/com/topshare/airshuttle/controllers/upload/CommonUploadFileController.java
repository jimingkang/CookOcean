package com.topshare.airshuttle.controllers.upload;

import java.io.File;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Post;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.topshare.airshuttle.common.util.Constants;
import com.topshare.airshuttle.common.util.FileUtils;
import com.topshare.airshuttle.common.util.IdTool;
import com.topshare.airshuttle.common.util.ResponseObject;
import com.topshare.airshuttle.controllers.BaseController;

/***
 * 通用文件上传
 * @author root
 *
 */
@Path("/commonUploadFile")
public class CommonUploadFileController extends BaseController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	//用户信息
	private static final Integer UPLOADTYPE_USERMSG = 0;
	
	/***
	 * 单个文件上传
	 * @param multipartFile
	 * @param uploadType 上传类型（用户信息相关）
	 * @return
	 */
	@Post("/doUpload")
	public String doUpload(Invocation inv,@Param("file") MultipartFile multipartFile,@Param("uploadType") Integer uploadType) throws Exception{
		
		logger.info("文件长度: " + multipartFile.getSize());
		logger.info("文件类型: " + multipartFile.getContentType());
		logger.info("文件名称: " + multipartFile.getName());
		logger.info("文件原名: " + multipartFile.getOriginalFilename());
		logger.info("========================================");
		
		Integer curUserId = this.getCurUserId(inv);
		
		//用户信息上传
		if(uploadType == UPLOADTYPE_USERMSG){
			
			String onlyId = IdTool.getId();//生成唯一的字符串
			
			String uploadFold = Constants.USERMSG_FOLD + curUserId;
			//如果文件夹不存在，则创建一个
			FileUtils.mkdir(uploadFold);
			
			String extName = FileUtils.getExtName(multipartFile.getOriginalFilename());
			
			String tempPath = uploadFold +"/"+ onlyId + "."+extName;
			
			File file = new File(tempPath);
			multipartFile.transferTo(file);
	
			String virtualFilePath = Constants.USERMSG_FOLD_VIRTUALPATH + curUserId +"/"+ onlyId + "."+extName;
			
			return "@"+this.returnObjectToJson(ResponseObject.newSuccessResponseObject(virtualFilePath));
		}
		
		return "@"+this.returnObjectToJson(ResponseObject.newErrorResponseObject("上传失败"));
	}
}
