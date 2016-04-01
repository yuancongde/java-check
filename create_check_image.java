package check_image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class create_check_image {
	private int imgWidth=0;
	private int imgHeight=0;
	private int fontHeight;
	private String fontStyle;
	
	public void init(int imgWidth, int imgHeight, String fontStyle){
		this.imgWidth = imgWidth;
		this.imgHeight = imgHeight;
		this.fontStyle = fontStyle;
	    fontHeight = imgHeight - 2;
	}
	Color getRandColor(int fc, int bc){
		Random random = new Random();
		if(fc>255) fc=255;
		if(bc>255) bc=255;
		int r=fc+random.nextInt(bc-fc);
		int g=fc+random.nextInt(bc-fc);
		int b=fc+random.nextInt(bc-fc);
		
		return new Color(r,g,b);
	}
	protected void create_check(){
		BufferedImage image = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_BGR);
		Graphics2D g = image.createGraphics();
		Random random = new Random();
		g.setColor(getRandColor(150,250));
		g.fillRect(0, 0, imgWidth, imgHeight);
		
		g.setFont(new Font(fontStyle,Font.PLAIN+Font.ITALIC, fontHeight));
		
		g.setColor(new Color(55,55,12));
		g.drawRect(0, 0, imgWidth-1, imgHeight-1);
		
		g.setColor(getRandColor(100,200));
		for(int i=0;i<400;i++){
			int x = random.nextInt(imgWidth);
	        int y = random.nextInt(imgHeight);
	        int xl = random.nextInt(12);
	        int yl = random.nextInt(12);
	        g.setColor(getRandColor(20,110));  
	        g.drawLine(x, y, x + xl, y + yl);
		}
		
		for(int i=0;i<170;i++){
			int x = random.nextInt(imgWidth-1);
	        int y = random.nextInt(imgHeight-1);
	        int xl = random.nextInt(12)+1;
	        int yl = random.nextInt(6)+1;
	        g.setColor(getRandColor(20,110));  
	        g.drawLine(x, y, x + xl, y + yl);
		}
		String sRand="";     
        for (int i=0;i<6;i++)     
        {
        	int w = (imgWidth-18)/6;
        	int gtmp = random.nextInt(40);
        	int itmp=0;
        	if(gtmp<=9)
        		itmp = gtmp+'0';
        	else if(gtmp<=26)
        		itmp = random.nextInt(26) + 65;  
        	else
        		itmp = random.nextInt(26) + 'a';
            char ctmp = (char)itmp;     
            sRand += String.valueOf(ctmp);     
            g.setColor(getRandColor(20,40));    
            g.drawString(String.valueOf(ctmp),w*i+3,imgHeight-imgHeight/10);     
        }        
        g.dispose();     
        try {
			ImageIO.write(image, "PNG", new File("D:\\check\\"+sRand+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}     
		
	}
}





















