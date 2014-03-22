package com.mulesoft.demo.lights;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mule.api.transformer.TransformerException;
import org.mule.module.blink1.PatternEntry;
import org.mule.transformer.AbstractTransformer;

public class GoDisco extends AbstractTransformer {

	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {

		Map params = (Map)src;
		String[] colors= "red,green,blue,cyan,magenta,white,yellow".split(",");
		List<PatternEntry> pattern = new ArrayList<PatternEntry>();
		for (String color : colors) {
			pattern.add(new PatternEntry(1000, color.trim()));
		}
		params.put("pattern", pattern);
		return params;
	}
}