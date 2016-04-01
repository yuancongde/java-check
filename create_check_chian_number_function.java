package check_image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.awt.geom.AffineTransform;

import javax.imageio.ImageIO;

public class create_check_chian_number_function {
	private int imgWidth=0;
	private int imgHeight=0;
	private int fontHeight;
	private String fontStyle;
	
	public void init(int imgWidth, int imgHeight,String fontStyle){
		this.imgWidth = imgWidth;
		this.imgHeight = imgHeight;
		this.fontStyle = fontStyle;
	    this.fontHeight = imgHeight - imgHeight/6;
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
		String s="";
		String[] str =new String[]{"加上","乘以","除以","减去","等于?"};
		
    	
    	int one_tmp = random.nextInt(99);
    	s=sRand += String.valueOf(one_tmp);
    	int two_tmp = random.nextInt(3);    
        s=sRand +=str[two_tmp];  
        int three_tmp = random.nextInt(99);
    	s=sRand += String.valueOf(three_tmp);
    	sRand += str[4];
    	char[] test = sRand.toCharArray();
    	int w = (imgWidth-1*test.length)/test.length;
        for (int i=0;i<test.length;i++)     
        {
        	 Graphics2D g2d = (Graphics2D)g;
        	 AffineTransform at_1 = new AffineTransform();
        	 g2d.setColor(getRandColor(100,200));
        	 int num_i = random.nextInt(3);
        	 g2d.drawString(String.valueOf(test[i]),w*i+num_i,fontHeight-2);
        	 int num = random.nextInt(4);
        	 at_1.setToRotation(num*Math.PI / 180);
        	 g2d.setTransform(at_1);
        }        
        g.dispose();
        int number=0;
        switch(two_tmp){
        case 0:
        	number = one_tmp+three_tmp;
        	break;
        case 1:
        	number = one_tmp*three_tmp;
        	break;
        case 2:
        	if(three_tmp !=0)
        		number = one_tmp/three_tmp;
        	else
        		number =0;
        	break;
        case 3:
        	number = one_tmp-three_tmp;
        	break;
        }
        String strlist ="";
        strlist += String.valueOf(number);
        strlist+="_"+s+".png";
       
        try {
			ImageIO.write(image, "PNG", new File("D:\\check11\\"+strlist));
		} catch (IOException e) {
			e.printStackTrace();
		}     
		
	}
}





















