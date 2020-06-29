package vn.yinx.autodeploy.controllers;

import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.yinx.autodeploy.models.IdCard;

@Controller
@RequestMapping("/api/v1/ocr")
public class ocr {
	@PostMapping("")
	public ResponseEntity<JSONObject> getAll(@RequestBody IdCard idCard) {
		// Save
		idCard.getImage();
		JSONObject res = new JSONObject();
		res.put("name", "Yin");
		res.put("birth", "15/06/1996");
		res.put("birth-place", "Thai Binh");
		return ResponseEntity.ok(res);
	}
}
