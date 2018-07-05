package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import model.bean.News;

@Controller
@RequestMapping("/cnews")
public class CnewsController {
	private final String DIR_UPLOAD = "uploads";

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {

		return "cnews.index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {

		return "cnews.add";
	}

	@RequestMapping(value = "/cat", method = RequestMethod.GET)
	public String cat() {

		return "cnews.cat";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail() {

		return "cnews.detail";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("news1") News news,BindingResult br, @RequestParam("hinhanh") CommonsMultipartFile cmf,
			HttpServletRequest request) {
		if(br.hasErrors()) {// ktra nếu có lỗi
			return "cnews.add";
		}
		
		// System.out.println(news.toString());
		// System.out.println("picture:" +cmf.getOriginalFilename()); //lấy tên file //bindingresul trả về kq có lỗi hay k
		String fileName = cmf.getOriginalFilename(); // têm hình ảnh
		if (!"".equals(fileName)) {
			String appParth = request.getServletContext().getRealPath(""); // web-content
			// String dirPath = appParth +"uploads";
			String dirPath = appParth + DIR_UPLOAD;
			File dir = new File(dirPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			String filePath = dirPath + File.separator + fileName; // uploads/tenanh
			// System.out.println("đuôi file:" +FilenameUtils.getExtension(fileName)); lấy
			// đuôi file
			try {
				cmf.transferTo(new File(filePath));
				System.out.println(filePath);
				System.out.println("thành công");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "cnews.add";
	}

}
