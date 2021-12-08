package br.com.start;

import java.io.IOException;

import javax.swing.SwingUtilities;

import br.com.minimercado.MercadoMini;

public class startMini {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					new MercadoMini().miniMercado();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
	}
}
