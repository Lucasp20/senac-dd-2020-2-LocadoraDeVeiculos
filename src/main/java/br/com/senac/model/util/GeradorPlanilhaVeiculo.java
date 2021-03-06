package br.com.senac.model.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.senac.model.vo.ClienteVO;
import br.com.senac.model.vo.VeiculoVO;

public class GeradorPlanilhaVeiculo {

	
	public String gerarPlanilhaVeiculos(String caminhoArquivo, List<VeiculoVO> veiculos) {
		// Criar a planilha (Workbook)
		XSSFWorkbook planilha = new XSSFWorkbook();

		// Criar uma aba (Sheet)
		XSSFSheet aba = planilha.createSheet("Veículo");

		int linhaAtual = 0;

		// Criar o cabeçalho (header)
		String[] nomesColunas = { "#", "Placa", "Marca", "Modelo", "Cor" };
		criarCabecalho(nomesColunas, aba, linhaAtual);
		
		linhaAtual++;
		
		// Preencher as linhas com os produtos
		criarLinhasVeiculos(veiculos, aba, linhaAtual);

		// Salvar o arquivo gerado no disco
		return salvarNoDisco(planilha, caminhoArquivo, ".xlsx");
	}

	private void criarLinhasVeiculos(List<VeiculoVO> veiculos, XSSFSheet aba, int posicaoLinhaAtual) {
		for (VeiculoVO p : veiculos) {
			// criar uma nova linha na planilha
			XSSFRow linhaAtual = aba.createRow(posicaoLinhaAtual);

			// Preencher as células com os atributos do Produto p
			linhaAtual.createCell(0).setCellValue(p.getIdVeiculo());
			linhaAtual.createCell(1).setCellValue(p.getPlaca());
			linhaAtual.createCell(2).setCellValue(p.getMarca());
			linhaAtual.createCell(3).setCellValue(p.getModelo());
			linhaAtual.createCell(4).setCellValue(p.getCor());
			
			// Converter para Date
			// linhaAtual.createCell(4).setCellValue(new Date(p.get));

			posicaoLinhaAtual++;
		}

	}

	private void criarCabecalho(String[] nomesColunas, XSSFSheet aba, int posicaoLinhaAtual) {
		Row linhaAtual = aba.createRow(posicaoLinhaAtual);

		posicaoLinhaAtual++;
		// Para mudar o estilo:
		// https://stackoverflow.com/questions/43467253/setting-style-in-apache-poi
		for (int i = 0; i < nomesColunas.length; i++) {
			Cell novaCelula = linhaAtual.createCell(i);
			novaCelula.setCellValue(nomesColunas[i]);
		}
	}

	private String salvarNoDisco(XSSFWorkbook planilha, String caminhoArquivo, String extensao) {
		String mensagem = "";
		FileOutputStream saida = null;

		try {
			saida = new FileOutputStream(new File(caminhoArquivo + extensao));
			planilha.write(saida);
			mensagem = "Planilha gerada com sucesso!";
		} catch (FileNotFoundException e) {
			// TODO lançar exceções de negócio (para poder capturar as causas no controller
			// ou tela)
			mensagem = "Erro ao tentar salvar planilha em: " + caminhoArquivo + extensao;
			System.out.println("Causa: " + e.getMessage());
		} catch (IOException e) {
			mensagem = "Erro ao tentar salvar planilha em: " + caminhoArquivo + extensao;
			System.out.println("Causa: " + e.getMessage());
		} finally {
			if (saida != null) {
				try {
					saida.close();
					planilha.close();
				} catch (IOException e) {
					mensagem = "Erro ao tentar salvar planilha em: " + caminhoArquivo + extensao;
					System.out.println("Causa: " + e.getMessage());
				}
			}
		}

		return mensagem;
	}
}