package lj.tools;

import java.util.zip.CRC32;

public class DataCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "3^<=4^R|||||P|||20131107093951|20131107215136\20131107180738|PHOENIX^^^1B4"
				+  "R|12|^^^AST_MIC^425052478517^PIP|INST_COMPLETE^64^I|||||P|||20131107093951|20131107215136\20131107200742|PHOENIX^^^1^B4"
				+ "R|13|^^^AST_MIC^425052478517^AMC|INST_COMPLET";
		
		s = "0COMPLETE^<=1^S|||||P|||20131107093951|20131107215136\\20131107170739|PHOENIX^^^1^B4"
				+ "\rR|6|^^^AST_MIC^425052478517^CZ|INST_COMPLETE^8^R|||||P|||20131107093951|20131107215136\\20131107173133|PHOENIX^^^1^B4"
				+ "\rR|7|^^^AST_MIC^425052478517^CAZ|INST_COM";
		
		s = "5R|19|^^^AST_MIC^425052478517^CIP|INST_COMPLETE^1^S|||||P|||20131107093951|20131107215136\\20131107170739|PHOENIX^^^1^B4";
		//byte[] bs = {0x02,0x3A,(byte)0xB4,0x23};
		
		System.out.println((dataCheckBSC(s.getBytes())));
		System.out.println((byte)0x02);
	}
	public static long dataCheckCRC(String inputstr){
		CRC32 c = new CRC32();
		c.reset();
		c.update(inputstr.getBytes());
		return c.getValue();
	}
	public static byte dataCheckBSC(byte[] bs){
		byte sum = 0x02;
		for(int i=0;i<bs.length;i++){
			sum = (byte)(sum + bs[i]);
		}
		sum = (byte)(~sum + 1);
		return (byte)sum;
	}
}
