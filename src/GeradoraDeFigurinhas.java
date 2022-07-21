import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;


import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Font;


public class GeradoraDeFigurinhas {
 
 
 
 
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

    // Leitura da imagem
    //InputStream inputStream = new FileInputStream(new File("img/filme-grande.jpg")); 
    // InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@.jpg").openStream();     - por link
    BufferedImage imagemOriginal = ImageIO.read(inputStream);


    // Cria nova imagem em memória com transparência e com tamanho novo 
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    // copiar a imagem original para nova imagem (em memória)
    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imagemOriginal, 0, 0, null);
    

    // configurar fonte
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.GREEN);
        graphics.setFont(font);


    // escrever uma frase na nova imagem
    graphics.drawString( "TOPZERA", 250, novaAltura - 50);
   
   
    //  escrever a imagem nova em um arquivo
    ImageIO.write(novaImagem, "png", new File (nomeArquivo) );

   
    
   }

}
