package org.brioscia.h2j.example.download1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

import org.brioscia.javaz.h2j.filter.H2JContext;

@Named
@RequestScoped
public class Download {

	@Inject
	private H2JContext context;

	private String nome;

	public void download() {
		HttpServletResponse response;
		OutputStream stream;
		FileInputStream fis;
		File file;
		byte[] block;
		int size;
		int r;

		this.context.setDirectResponse(true); // indica che il metodo effettuerà la commit sulla response
		this.context.setRefresh(true); // indica di rinfrescare i valori di bind dei nome del filtro (non cancella gli
										// attuali riferimenti e mantiene vivi i riferimenti della pagina html sul
										// client)
		size = 4096;
		block = new byte[size];

		response = (HttpServletResponse) this.context.getResponse();
		try {
			file = new File(this.nome);

			response.setContentType("application/octect");
			response.addHeader("Content-Disposition", "attachment; filename=" + file.getName());
			response.setContentLength((int) file.length());

			stream = response.getOutputStream();
			fis = new FileInputStream(file);
			while ((r = fis.read(block)) != -1) {
				stream.write(block, 0, r);
			}
			stream.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
