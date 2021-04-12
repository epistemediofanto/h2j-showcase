package org.brioscia.h2j.demo.upload1;

import java.io.InputStream;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.brioscia.javaz.h2j.filter.H2JContext;

@Named
@RequestScoped
public class Upload {

	@Inject
	private H2JContext context;

	private String nome;

	public String upload() {
		HttpServletRequest request;
		HttpServletResponse response;
		InputStream filecontent = null;
		int read;
		byte[] bytes;

		try {
//			this.context.processReuest();
			allowCasualMultipartParsing="true"

			request = (HttpServletRequest) this.context.getRequest();
			response = (HttpServletResponse) this.context.getResponse();

			final Part filePart = request.getPart("file");
			final String fileName = getFileName(filePart);

			bytes = new byte[4096];
			filecontent = filePart.getInputStream();
			while ((read = filecontent.read(bytes)) != -1) {
//				out.write(bytes, 0, read);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "example.xhtml";
	}

	private String getFileName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
