
package br.com.projeto.util;

import br.com.projeto.excecoes.ExcecaoSistema;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Usuario
 */
public class LeitorPropriedades {

    private Properties propriedades;

    public LeitorPropriedades(String[] nomesArquivo) {
        propriedades = new Properties();
        InputStream is;

        for (String nome : nomesArquivo) {
            is = this.getClass().getClassLoader().getResourceAsStream(nome);

            if (is != null) {
                try {
                    propriedades.load(is);
                    is.close();
                } catch (IOException ex) {
                    throw new ExcecaoSistema(ex);
                }
            }
        }
    }

    public String get(String chave) {
        return propriedades.getProperty(chave);
    }

    public synchronized void adicionar(String chave, String valor) {
        propriedades.put(chave, valor);
    }
}
