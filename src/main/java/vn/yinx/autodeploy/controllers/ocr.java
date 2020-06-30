package vn.yinx.autodeploy.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import vn.yinx.autodeploy.models.IdCard;
import vn.yinx.autodeploy.util.HttpUtils;

@Controller
@RequestMapping("/api/v1/ocr")
public class ocr {
	@PostMapping("")
	public ResponseEntity<JSONObject> getAll(@RequestBody IdCard idCard) {
		// Save
		JSONObject res = new JSONObject();// value return
		res.put("status", 1);// default: success
		byte[] data = Base64.getDecoder()
                .decode(idCard.getImage().getBytes(StandardCharsets.UTF_8));
	    FileOutputStream fos;
		try {
			fos = new FileOutputStream(new File("C:\\\\Users\\\\admin\\\\AndroidStudioProjects\\\\FPT_ID_CARD_DETECT\\\\app\\\\src\\\\main\\\\res\\\\drawable\\\\myImage.jpg"));
			fos.write(data); 
		    fos.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	    
	    File fo = new File(
				"C:\\Users\\admin\\AndroidStudioProjects\\FPT_ID_CARD_DETECT\\app\\src\\main\\res\\drawable\\myImage.jpg");
		try {
//			Files.write(fo.toPath(), data);
			JSONObject rs = HttpUtils.sendFile("https://api.fpt.ai/vision/idr/vnm", "vCtTr8rKRVKgHlQuoijreDNF3Mc0inhT",
					fo);
			res.put("data", rs.get("data"));// put data by key "data"
			return ResponseEntity.ok(res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.put("status", 0);
			res.put("message", e.getMessage());
			return ResponseEntity.ok((JSONObject) res.get("data"));
		}
//		JSONObject res = new JSONObject();
//		res.put("name", "Yin");
//		res.put("birth", "15/06/1996");
//		res.put("birth-place", "Thai Binh");
//		return ResponseEntity.ok(res);
	}
}
