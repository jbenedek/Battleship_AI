package com.Battleship;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

	String a1 = " ";
	String a2 = " ";
	String a3 = " ";
	String a4 = " ";
	String a5 = " ";
	String a6 = " ";
	String a7 = " ";
	String a8 = " ";
	String a9 = " ";
	String a10 = " ";
	
	String b1 = " ";
	String b2 = " ";
	String b3 = " ";
	String b4 = " ";
	String b5 = " ";
	String b6 = " ";
	String b7 = " ";
	String b8 = " ";
	String b9 = " ";
	String b10 = " ";
	
	String c1 = " ";
	String c2 = " ";
	String c3 = " ";
	String c4 = " ";
	String c5 = " ";
	String c6 = " ";
	String c7 = " ";
	String c8 = " ";
	String c9 = " ";
	String c10 = " ";
	
	String d1 = " ";
	String d2 = " ";
	String d3 = " ";
	String d4 = " ";
	String d5 = " ";
	String d6 = " ";
	String d7 = " ";
	String d8 = " ";
	String d9 = " ";
	String d10 = " ";
	
	String e1 = " ";
	String e2 = " ";
	String e3 = " ";
	String e4 = " ";
	String e5 = " ";
	String e6 = " ";
	String e7 = " ";
	String e8 = " ";
	String e9 = " ";
	String e10 = " ";
	
	String f1 = " ";
	String f2 = " ";
	String f3 = " ";
	String f4 = " ";
	String f5 = " ";
	String f6 = " ";
	String f7 = " ";
	String f8 = " ";
	String f9 = " ";
	String f10 = " ";
	
	String g1 = " ";
	String g2 = " ";
	String g3 = " ";
	String g4 = " ";
	String g5 = " ";
	String g6 = " ";
	String g7 = " ";
	String g8 = " ";
	String g9 = " ";
	String g10 = " ";
	
	String h1 = " ";
	String h2 = " ";
	String h3 = " ";
	String h4 = " ";
	String h5 = " ";
	String h6 = " ";
	String h7 = " ";
	String h8 = " ";
	String h9 = " ";
	String h10 = " ";
	
	String i1 = " ";
	String i2 = " ";
	String i3 = " ";
	String i4 = " ";
	String i5 = " ";
	String i6 = " ";
	String i7 = " ";
	String i8 = " ";
	String i9 = " ";
	String i10 = " ";
	
	String j1 = " ";
	String j2 = " ";
	String j3 = " ";
	String j4 = " ";
	String j5 = " ";
	String j6 = " ";
	String j7 = " ";
	String j8 = " ";
	String j9 = " ";
	String j10 = " ";
	
	String za1 = " ";
	String za2 = " ";
	String za3 = " ";
	String za4 = " ";
	String za5 = " ";
	String za6 = " ";
	String za7 = " ";
	String za8 = " ";
	String za9 = " ";
	String za10 = " ";
	
	String zb1 = " ";
	String zb2 = " ";
	String zb3 = " ";
	String zb4 = " ";
	String zb5 = " ";
	String zb6 = " ";
	String zb7 = " ";
	String zb8 = " ";
	String zb9 = " ";
	String zb10 = " ";
	
	String zc1 = " ";
	String zc2 = " ";
	String zc3 = " ";
	String zc4 = " ";
	String zc5 = " ";
	String zc6 = " ";
	String zc7 = " ";
	String zc8 = " ";
	String zc9 = " ";
	String zc10 = " ";
	
	String zd1 = " ";
	String zd2 = " ";
	String zd3 = " ";
	String zd4 = " ";
	String zd5 = " ";
	String zd6 = " ";
	String zd7 = " ";
	String zd8 = " ";
	String zd9 = " ";
	String zd10 = " ";
	
	String ze1 = " ";
	String ze2 = " ";
	String ze3 = " ";
	String ze4 = " ";
	String ze5 = " ";
	String ze6 = " ";
	String ze7 = " ";
	String ze8 = " ";
	String ze9 = " ";
	String ze10 = " ";
	
	String zf1 = " ";
	String zf2 = " ";
	String zf3 = " ";
	String zf4 = " ";
	String zf5 = " ";
	String zf6 = " ";
	String zf7 = " ";
	String zf8 = " ";
	String zf9 = " ";
	String zf10 = " ";
	
	String zg1 = " ";
	String zg2 = " ";
	String zg3 = " ";
	String zg4 = " ";
	String zg5 = " ";
	String zg6 = " ";
	String zg7 = " ";
	String zg8 = " ";
	String zg9 = " ";
	String zg10 = " ";

	String zh1 = " ";
	String zh2 = " ";
	String zh3 = " ";
	String zh4 = " ";
	String zh5 = " ";
	String zh6 = " ";
	String zh7 = " ";
	String zh8 = " ";
	String zh9 = " ";
	String zh10 = " ";
	
	String zi1 = " ";
	String zi2 = " ";
	String zi3 = " ";
	String zi4 = " ";
	String zi5 = " ";
	String zi6 = " ";
	String zi7 = " ";
	String zi8 = " ";
	String zi9 = " ";
	String zi10 = " ";
	
	String zj1 = " ";
	String zj2 = " ";
	String zj3 = " ";
	String zj4 = " ";
	String zj5 = " ";
	String zj6 = " ";
	String zj7 = " ";
	String zj8 = " ";
	String zj9 = " ";
	String zj10 = " ";
	
	public Utils(Board off, Board def) {
		List<Tile> toMarkOff = new ArrayList<>();
		List<Tile> toMarkDef = new ArrayList<>();

		toMarkOff.addAll(off.getListOfHits()); //Need to only show hits on Player's Offensive board
		toMarkOff.addAll(off.getListOfMisses());
		
		for(Tile t: toMarkOff) {
			switch(t.getCoord().getSingleValueRepresentation()) {
			///////////////////////AAA//////////////////////////////////////////////
			case 11: //a1
				a1 = t.getSymbol();
				break;
			case 12: //a2
				a2 = t.getSymbol();
				break;
			case 13: //a3
				a3 = t.getSymbol();
				break;
			case 14:
				a4 = t.getSymbol();
				break;
			case 15:
				a5 = t.getSymbol();
				break;
			case 16:
				a6 = t.getSymbol();
				break;
			case 17:
				a7 = t.getSymbol();
				break;
			case 18:
				a8 = t.getSymbol();
				break;
			case 19:
				a9 = t.getSymbol();
				break;
			case 110:
				a10 = t.getSymbol();
				break;
			////////////////////////BBBBBBBBBBBBBBBBB///////////////////////////////////////////
			case 21: //b1
				b1 = t.getSymbol();
				break;
			case 22: //b2
				b2 = t.getSymbol();
				break;
			case 23: //b3
				b3 = t.getSymbol();
				break;
			case 24:
				b4 = t.getSymbol();
				break;
			case 25:
				b5 = t.getSymbol();
				break;
			case 26:
				b6 = t.getSymbol();
				break;
			case 27:
				b7 = t.getSymbol();
				break;
			case 28:
				b8 = t.getSymbol();
				break;
			case 29:
				b9 = t.getSymbol();
				break;
			case 210:
				b10 = t.getSymbol();
				break;
			//////////CCCCCCCCCCCCCCCC?////////////////////////////////
			case 31: //c1
				c1 = t.getSymbol();
				break;
			case 32: 
				c2 = t.getSymbol();
				break;
			case 33: 
				c3 = t.getSymbol();
				break;
			case 34:
				c4 = t.getSymbol();
				break;
			case 35:
				c5 = t.getSymbol();
				break;
			case 36:
				c6 = t.getSymbol();
				break;
			case 37:
				c7 = t.getSymbol();
				break;
			case 38:
				c8 = t.getSymbol();
				break;
			case 39:
				c9 = t.getSymbol();
				break;
			case 310:
				c10 = t.getSymbol();
				break;
			////////DDDDDDDDDDD///////////////////////////////
			case 41: //d1
				d1 = t.getSymbol();
				break;
			case 42: 
				d2 = t.getSymbol();
				break;
			case 43: 
				d3 = t.getSymbol();
				break;
			case 44:
				d4 = t.getSymbol();
				break;
			case 45:
				d5 = t.getSymbol();
				break;
			case 46:
				d6 = t.getSymbol();
				break;
			case 47:
				d7 = t.getSymbol();
				break;
			case 48:
				d8 = t.getSymbol();
				break;
			case 49:
				d9 = t.getSymbol();
				break;
			case 410:
				d10 = t.getSymbol();
				break;
			///////////////EEE//////////////////////////////////
			case 51: //e1
				e1 = t.getSymbol();
				break;
			case 52: 
				e2 = t.getSymbol();
				break;
			case 53: 
				e3 = t.getSymbol();
				break;
			case 54:
				e4 = t.getSymbol();
				break;
			case 55:
				e5 = t.getSymbol();
				break;
			case 56:
				e6 = t.getSymbol();
				break;
			case 57:
				e7 = t.getSymbol();
				break;
			case 58:
				e8 = t.getSymbol();
				break;
			case 59:
				e9 = t.getSymbol();
				break;
			case 510:
				e10 = t.getSymbol();
				break;
			///////FFFFFFFFFFFFF////////////////////////////
			case 61: //f1
				f1 = t.getSymbol();
				break;
			case 62: 
				f2 = t.getSymbol();
				break;
			case 63: 
				f3 = t.getSymbol();
				break;
			case 64:
				f4 = t.getSymbol();
				break;
			case 65:
				f5 = t.getSymbol();
				break;
			case 66:
				f6 = t.getSymbol();
				break;
			case 67:
				f7 = t.getSymbol();
				break;
			case 68:
				f8 = t.getSymbol();
				break;
			case 69:
				f9 = t.getSymbol();
				break;
			case 610:
				f10 = t.getSymbol();
				break;	
			///////////GGG//////////////////
			case 71: //g1
				g1 = t.getSymbol();
				break;
			case 72: 
				g2 = t.getSymbol();
				break;
			case 73: 
				g3 = t.getSymbol();
				break;
			case 74:
				g4 = t.getSymbol();
				break;
			case 75:
				g5 = t.getSymbol();
				break;
			case 76:
				g6 = t.getSymbol();
				break;
			case 77:
				g7 = t.getSymbol();
				break;
			case 78:
				g8 = t.getSymbol();
				break;
			case 79:
				g9 = t.getSymbol();
				break;
			case 710:
				g10 = t.getSymbol();
				break;
			////HHH///////////////////////////////////
			case 81: //h1
				h1 = t.getSymbol();
				break;
			case 82: 
				h2 = t.getSymbol();
				break;
			case 83: 
				h3 = t.getSymbol();
				break;
			case 84:
				h4 = t.getSymbol();
				break;
			case 85:
				h5 = t.getSymbol();
				break;
			case 86:
				h6 = t.getSymbol();
				break;
			case 87:
				h7 = t.getSymbol();
				break;
			case 88:
				h8 = t.getSymbol();
				break;
			case 89:
				h9 = t.getSymbol();
				break;
			case 810:
				h10 = t.getSymbol();
				break;
			/////IIIIII////////////////////
			case 91: //i1
				i1 = t.getSymbol();
				break;
			case 92: 
				i2 = t.getSymbol();
				break;
			case 93: 
				i3 = t.getSymbol();
				break;
			case 94:
				i4 = t.getSymbol();
				break;
			case 95:
				i5 = t.getSymbol();
				break;
			case 96:
				i6 = t.getSymbol();
				break;
			case 97:
				i7 = t.getSymbol();
				break;
			case 98:
				i8 = t.getSymbol();
				break;
			case 99:
				i9 = t.getSymbol();
				break;
			case 910:
				i10 = t.getSymbol();
				break;
			///////JJJJJJJ
			case 101: //j1
				j1 = t.getSymbol();
				break;
			case 102: 
				j2 = t.getSymbol();
				break;
			case 103: 
				j3 = t.getSymbol();
				break;
			case 104:
				j4 = t.getSymbol();
				break;
			case 105:
				j5 = t.getSymbol();
				break;
			case 106:
				j6 = t.getSymbol();
				break;
			case 107:
				j7 = t.getSymbol();
				break;
			case 108:
				j8 = t.getSymbol();
				break;
			case 109:
				j9 = t.getSymbol();
				break;
			case 1010:
				j10 = t.getSymbol();
				break;
			}
		}
		
		
		////////DEFENSE/////////////////////////////
		toMarkDef.addAll(def.getAllShipCoords());
		toMarkDef.addAll(def.getListOfMisses());
		for(Tile t: toMarkDef) {
			switch(t.getCoord().getSingleValueRepresentation()) {
			///////////////////////AAA//////////////////////////////////////////////
			case 11: //a1
				za1 = t.getSymbol();
				break;
			case 12: //a2
				za2 = t.getSymbol();
				break;
			case 13: //a3
				za3 = t.getSymbol();
				break;
			case 14:
				za4 = t.getSymbol();
				break;
			case 15:
				za5 = t.getSymbol();
				break;
			case 16:
				za6 = t.getSymbol();
				break;
			case 17:
				za7 = t.getSymbol();
				break;
			case 18:
				za8 = t.getSymbol();
				break;
			case 19:
				za9 = t.getSymbol();
				break;
			case 110:
				za10 = t.getSymbol();
				break;
			////////////////////////BBBBBBBBBBBBBBBBB///////////////////////////////////////////
			case 21: //b1
				zb1 = t.getSymbol();
				break;
			case 22: //b2
				zb2 = t.getSymbol();
				break;
			case 23: //b3
				zb3 = t.getSymbol();
				break;
			case 24:
				zb4 = t.getSymbol();
				break;
			case 25:
				zb5 = t.getSymbol();
				break;
			case 26:
				zb6 = t.getSymbol();
				break;
			case 27:
				zb7 = t.getSymbol();
				break;
			case 28:
				zb8 = t.getSymbol();
				break;
			case 29:
				zb9 = t.getSymbol();
				break;
			case 210:
				zb10 = t.getSymbol();
				break;
			//////////CCCCCCCCCCCCCCCC?////////////////////////////////
			case 31: //c1
				zc1 = t.getSymbol();
				break;
			case 32: 
				zc2 = t.getSymbol();
				break;
			case 33: 
				zc3 = t.getSymbol();
				break;
			case 34:
				zc4 = t.getSymbol();
				break;
			case 35:
				zc5 = t.getSymbol();
				break;
			case 36:
				zc6 = t.getSymbol();
				break;
			case 37:
				zc7 = t.getSymbol();
				break;
			case 38:
				zc8 = t.getSymbol();
				break;
			case 39:
				zc9 = t.getSymbol();
				break;
			case 310:
				zc10 = t.getSymbol();
				break;
			////////DDDDDDDDDDD///////////////////////////////
			case 41: //d1
				zd1 = t.getSymbol();
				break;
			case 42: 
				zd2 = t.getSymbol();
				break;
			case 43: 
				zd3 = t.getSymbol();
				break;
			case 44:
				zd4 = t.getSymbol();
				break;
			case 45:
				zd5 = t.getSymbol();
				break;
			case 46:
				zd6 = t.getSymbol();
				break;
			case 47:
				zd7 = t.getSymbol();
				break;
			case 48:
				zd8 = t.getSymbol();
				break;
			case 49:
				zd9 = t.getSymbol();
				break;
			case 410:
				zd10 = t.getSymbol();
				break;
			///////////////EEE//////////////////////////////////
			case 51: //e1
				ze1 = t.getSymbol();
				break;
			case 52: 
				ze2 = t.getSymbol();
				break;
			case 53: 
				ze3 = t.getSymbol();
				break;
			case 54:
				ze4 = t.getSymbol();
				break;
			case 55:
				ze5 = t.getSymbol();
				break;
			case 56:
				ze6 = t.getSymbol();
				break;
			case 57:
				ze7 = t.getSymbol();
				break;
			case 58:
				ze8 = t.getSymbol();
				break;
			case 59:
				ze9 = t.getSymbol();
				break;
			case 510:
				ze10 = t.getSymbol();
				break;
			///////FFFFFFFFFFFFF////////////////////////////
			case 61: //f1
				zf1 = t.getSymbol();
				break;
			case 62: 
				zf2 = t.getSymbol();
				break;
			case 63: 
				zf3 = t.getSymbol();
				break;
			case 64:
				zf4 = t.getSymbol();
				break;
			case 65:
				zf5 = t.getSymbol();
				break;
			case 66:
				zf6 = t.getSymbol();
				break;
			case 67:
				zf7 = t.getSymbol();
				break;
			case 68:
				zf8 = t.getSymbol();
				break;
			case 69:
				zf9 = t.getSymbol();
				break;
			case 610:
				zf10 = t.getSymbol();
				break;	
			///////////GGG//////////////////
			case 71: //g1
				zg1 = t.getSymbol();
				break;
			case 72: 
				zg2 = t.getSymbol();
				break;
			case 73: 
				zg3 = t.getSymbol();
				break;
			case 74:
				zg4 = t.getSymbol();
				break;
			case 75:
				zg5 = t.getSymbol();
				break;
			case 76:
				zg6 = t.getSymbol();
				break;
			case 77:
				zg7 = t.getSymbol();
				break;
			case 78:
				zg8 = t.getSymbol();
				break;
			case 79:
				zg9 = t.getSymbol();
				break;
			case 710:
				zg10 = t.getSymbol();
				break;
			////HHH///////////////////////////////////
			case 81: //h1
				zh1 = t.getSymbol();
				break;
			case 82: 
				zh2 = t.getSymbol();
				break;
			case 83: 
				zh3 = t.getSymbol();
				break;
			case 84:
				zh4 = t.getSymbol();
				break;
			case 85:
				zh5 = t.getSymbol();
				break;
			case 86:
				zh6 = t.getSymbol();
				break;
			case 87:
				zh7 = t.getSymbol();
				break;
			case 88:
				zh8 = t.getSymbol();
				break;
			case 89:
				zh9 = t.getSymbol();
				break;
			case 810:
				zh10 = t.getSymbol();
				break;
			/////IIIIII////////////////////
			case 91: //i1
				zi1 = t.getSymbol();
				break;
			case 92: 
				zi2 = t.getSymbol();
				break;
			case 93: 
				zi3 = t.getSymbol();
				break;
			case 94:
				zi4 = t.getSymbol();
				break;
			case 95:
				zi5 = t.getSymbol();
				break;
			case 96:
				zi6 = t.getSymbol();
				break;
			case 97:
				zi7 = t.getSymbol();
				break;
			case 98:
				zi8 = t.getSymbol();
				break;
			case 99:
				zi9 = t.getSymbol();
				break;
			case 910:
				zi10 = t.getSymbol();
				break;
			///////JJJJJJJ
			case 101: //j1
				zj1 = t.getSymbol();
				break;
			case 102: 
				zj2 = t.getSymbol();
				break;
			case 103: 
				zj3 = t.getSymbol();
				break;
			case 104:
				zj4 = t.getSymbol();
				break;
			case 105:
				zj5 = t.getSymbol();
				break;
			case 106:
				zj6 = t.getSymbol();
				break;
			case 107:
				zj7 = t.getSymbol();
				break;
			case 108:
				zj8 = t.getSymbol();
				break;
			case 109:
				zj9 = t.getSymbol();
				break;
			case 1010:
				zj10 = t.getSymbol();
				break;
			}
		}
	}
	
	public Utils(Board single) {
		List<Tile> toMark = new ArrayList<>();
		toMark.addAll(single.getAllShipCoords());
		toMark.addAll(single.getListOfMisses());
		for(Tile t: toMark) {
			switch(t.getCoord().getSingleValueRepresentation()) {
			///////////////////////AAA//////////////////////////////////////////////
			case 11: //a1
				a1 = t.getSymbol();
				break;
			case 12: //a2
				a2 = t.getSymbol();
				break;
			case 13: //a3
				a3 = t.getSymbol();
				break;
			case 14:
				a4 = t.getSymbol();
				break;
			case 15:
				a5 = t.getSymbol();
				break;
			case 16:
				a6 = t.getSymbol();
				break;
			case 17:
				a7 = t.getSymbol();
				break;
			case 18:
				a8 = t.getSymbol();
				break;
			case 19:
				a9 = t.getSymbol();
				break;
			case 110:
				a10 = t.getSymbol();
				break;
			////////////////////////BBBBBBBBBBBBBBBBB///////////////////////////////////////////
			case 21: //b1
				b1 = t.getSymbol();
				break;
			case 22: //b2
				b2 = t.getSymbol();
				break;
			case 23: //b3
				b3 = t.getSymbol();
				break;
			case 24:
				b4 = t.getSymbol();
				break;
			case 25:
				b5 = t.getSymbol();
				break;
			case 26:
				b6 = t.getSymbol();
				break;
			case 27:
				b7 = t.getSymbol();
				break;
			case 28:
				b8 = t.getSymbol();
				break;
			case 29:
				b9 = t.getSymbol();
				break;
			case 210:
				b10 = t.getSymbol();
				break;
			//////////CCCCCCCCCCCCCCCC?////////////////////////////////
			case 31: //c1
				c1 = t.getSymbol();
				break;
			case 32: 
				c2 = t.getSymbol();
				break;
			case 33: 
				c3 = t.getSymbol();
				break;
			case 34:
				c4 = t.getSymbol();
				break;
			case 35:
				c5 = t.getSymbol();
				break;
			case 36:
				c6 = t.getSymbol();
				break;
			case 37:
				c7 = t.getSymbol();
				break;
			case 38:
				c8 = t.getSymbol();
				break;
			case 39:
				c9 = t.getSymbol();
				break;
			case 310:
				c10 = t.getSymbol();
				break;
			////////DDDDDDDDDDD///////////////////////////////
			case 41: //d1
				d1 = t.getSymbol();
				break;
			case 42: 
				d2 = t.getSymbol();
				break;
			case 43: 
				d3 = t.getSymbol();
				break;
			case 44:
				d4 = t.getSymbol();
				break;
			case 45:
				d5 = t.getSymbol();
				break;
			case 46:
				d6 = t.getSymbol();
				break;
			case 47:
				d7 = t.getSymbol();
				break;
			case 48:
				d8 = t.getSymbol();
				break;
			case 49:
				d9 = t.getSymbol();
				break;
			case 410:
				d10 = t.getSymbol();
				break;
			///////////////EEE//////////////////////////////////
			case 51: //e1
				e1 = t.getSymbol();
				break;
			case 52: 
				e2 = t.getSymbol();
				break;
			case 53: 
				e3 = t.getSymbol();
				break;
			case 54:
				e4 = t.getSymbol();
				break;
			case 55:
				e5 = t.getSymbol();
				break;
			case 56:
				e6 = t.getSymbol();
				break;
			case 57:
				e7 = t.getSymbol();
				break;
			case 58:
				e8 = t.getSymbol();
				break;
			case 59:
				e9 = t.getSymbol();
				break;
			case 510:
				e10 = t.getSymbol();
				break;
			///////FFFFFFFFFFFFF////////////////////////////
			case 61: //f1
				f1 = t.getSymbol();
				break;
			case 62: 
				f2 = t.getSymbol();
				break;
			case 63: 
				f3 = t.getSymbol();
				break;
			case 64:
				f4 = t.getSymbol();
				break;
			case 65:
				f5 = t.getSymbol();
				break;
			case 66:
				f6 = t.getSymbol();
				break;
			case 67:
				f7 = t.getSymbol();
				break;
			case 68:
				f8 = t.getSymbol();
				break;
			case 69:
				f9 = t.getSymbol();
				break;
			case 610:
				f10 = t.getSymbol();
				break;	
			///////////GGG//////////////////
			case 71: //g1
				g1 = t.getSymbol();
				break;
			case 72: 
				g2 = t.getSymbol();
				break;
			case 73: 
				g3 = t.getSymbol();
				break;
			case 74:
				g4 = t.getSymbol();
				break;
			case 75:
				g5 = t.getSymbol();
				break;
			case 76:
				g6 = t.getSymbol();
				break;
			case 77:
				g7 = t.getSymbol();
				break;
			case 78:
				g8 = t.getSymbol();
				break;
			case 79:
				g9 = t.getSymbol();
				break;
			case 710:
				g10 = t.getSymbol();
				break;
			////HHH///////////////////////////////////
			case 81: //h1
				h1 = t.getSymbol();
				break;
			case 82: 
				h2 = t.getSymbol();
				break;
			case 83: 
				h3 = t.getSymbol();
				break;
			case 84:
				h4 = t.getSymbol();
				break;
			case 85:
				h5 = t.getSymbol();
				break;
			case 86:
				h6 = t.getSymbol();
				break;
			case 87:
				h7 = t.getSymbol();
				break;
			case 88:
				h8 = t.getSymbol();
				break;
			case 89:
				h9 = t.getSymbol();
				break;
			case 810:
				h10 = t.getSymbol();
				break;
			/////IIIIII////////////////////
			case 91: //i1
				i1 = t.getSymbol();
				break;
			case 92: 
				i2 = t.getSymbol();
				break;
			case 93: 
				i3 = t.getSymbol();
				break;
			case 94:
				i4 = t.getSymbol();
				break;
			case 95:
				i5 = t.getSymbol();
				break;
			case 96:
				i6 = t.getSymbol();
				break;
			case 97:
				i7 = t.getSymbol();
				break;
			case 98:
				i8 = t.getSymbol();
				break;
			case 99:
				i9 = t.getSymbol();
				break;
			case 910:
				i10 = t.getSymbol();
				break;
			///////JJJJJJJ
			case 101: //j1
				j1 = t.getSymbol();
				break;
			case 102: 
				j2 = t.getSymbol();
				break;
			case 103: 
				j3 = t.getSymbol();
				break;
			case 104:
				j4 = t.getSymbol();
				break;
			case 105:
				j5 = t.getSymbol();
				break;
			case 106:
				j6 = t.getSymbol();
				break;
			case 107:
				j7 = t.getSymbol();
				break;
			case 108:
				j8 = t.getSymbol();
				break;
			case 109:
				j9 = t.getSymbol();
				break;
			case 1010:
				j10 = t.getSymbol();
				break;
			}
		}
		
		
	}
	
	public void printSingleBoard() {
	    System.out.println(" ");
	    System.out.println("       A   B   C   D   E   F   G   H   I   J      ");
	    System.out.println("     =========================================    ");
	    System.out.println(" 1   | " + a1 + " | " + b1 + " | " + c1 + " | " + d1 + " | " + e1 + " | " + f1 + " | " + g1 + " | " + h1 + " | " + i1 + " | " + j1 + " |   1 ");
	    System.out.println("     =========================================     ");
	    System.out.println(" 2   | " + a2 + " | " + b2 + " | " + c2 + " | " + d2 + " | " + e2 + " | " + f2 + " | " + g2 + " | " + h2 + " | " + i2 + " | " + j2 + " |   2 ");
	    System.out.println("     =========================================      ");
	    System.out.println(" 3   | " + a3 + " | " + b3 + " | " + c3 + " | " + d3 + " | " + e3 + " | " + f3 + " | " + g3 + " | " + h3 + " | " + i3 + " | " + j3 + " |   3 ");
	    System.out.println("     =========================================     ");
	    System.out.println(" 4   | " + a4 + " | " + b4 + " | " + c4	+ " | " + d4 + " | " + e4 + " | " + f4 + " | " + g4 + " | " + h4 + " | " + i4 + " | " + j4 + " |   4 ");
	    System.out.println("     =========================================    ");
	    System.out.println(" 5   | " + a5 + " | " + b5 + " | " + c5 + " | " + d5 + " | " + e5 + " | " + f5 + " | " + g5 + " | " + h5 + " | " + i5 + " | " + j5 + " |   5 ");
	    System.out.println("     =========================================    ");
	    System.out.println(" 6   | " + a6 + " | " + b6 + " | " + c6 + " | " + d6 + " | " + e6 + " | " + f6 + " | " + g6 + " | " + h6 + " | " + i6 + " | " + j6 + " |   6 ");
	    System.out.println("     =========================================     ");
	    System.out.println(" 7   | " + a7 + " | " + b7 + " | " + c7 + " | " + d7 + " | " + e7 + " | " + f7 + " | " + g7 + " | " + h7 + " | " + i7 + " | " + j7 + " |   7 ");
	    System.out.println("     =========================================    ");
	    System.out.println(" 8   | " + a8 + " | " + b8 + " | " + c8 + " | " + d8 + " | " + e8 + " | " + f8 + " | " + g8 + " | " + h8 + " | " + i8 + " | " + j8 + " |   8 ");
	    System.out.println("     =========================================     ");
	    System.out.println(" 9   | " + a9 + " | " + b9 + " | " + c9 + " | " + d9 + " | " + e9 + " | " + f9 + " | " + g9 + " | " + h9 + " | " + i9 + " | " + j9 + " |   9 ");
	    System.out.println("     =========================================      ");
	    System.out.println(" 10  | " + a10 + " | " + b10 + " | " + c10 + " | " + d10 + " | " + e10 + " | " + f10 + " | " + g10 + " | " + h10 + " | " + i10 + " | " + j10 + " |   10 ");
	    System.out.println("     =========================================    ");
	    System.out.println("       A   B   C   D   E   F   G   H   I   J       ");
	    System.out.println(" ");
	}
	
	public void printDoubleBoard() {
	    System.out.println(" ");
	    System.out.println("               YOUR ATTACKS (OFFENSE)              |                YOUR SHIPS (DEFENSE)               ");
	    System.out.println("       A   B   C   D   E   F   G   H   I   J       |       A   B   C   D   E   F   G   H   I   J       ");
	    System.out.println("     =========================================     |     =========================================     ");
	    System.out.println(" 1   | " + a1 + " | " + b1 + " | " + c1 + " | " + d1 + " | " + e1 + " | " + f1 + " | " + g1 + " | " + h1 + " | " + i1 + " | " + j1 + " |   1 | 1   | " + za1 + " | " + zb1 + " | " + zc1 + " | " + zd1 + " | " + ze1 + " | " + zf1 + " | " + zg1 + " | " + zh1 + " | " + zi1 + " | " + zj1 + " |   1 ");
	    System.out.println("     =========================================     |     =========================================     ");
	    System.out.println(" 2   | " + a2 + " | " + b2 + " | " + c2 + " | " + d2 + " | " + e2 + " | " + f2 + " | " + g2 + " | " + h2 + " | " + i2 + " | " + j2 + " |   2 | 2   | " +	za2 + " | " + zb2 + " | " + zc2 + " | " + zd2 + " | " + ze2 + " | " + zf2 + " | " + zg2 + " | " + zh2 + " | " + zi2 + " | " + zj2+ " |   2 ");
	    System.out.println("     =========================================     |     =========================================     ");
	    System.out.println(" 3   | " + a3 + " | " + b3 + " | " + c3 + " | " + d3 + " | " + e3 + " | " + f3 + " | " + g3 + " | " + h3 + " | " + i3 + " | " + j3 + " |   3 | 3   | " + za3 + " | " + zb3 + " | " + zc3 + " | " + zd3 + " | " + ze3 + " | " + zf3 + " | " + zg3 + " | " + zh3 + " | " + zi3 + " | " + zj3	+ " |   3 ");
	    System.out.println("     =========================================     |     =========================================     ");
	    System.out.println(" 4   | " + a4 + " | " + b4 + " | " + c4	+ " | " + d4 + " | " + e4 + " | " + f4 + " | " + g4 + " | " + h4 + " | " + i4 + " | " + j4 + " |   4 | 4   | " +	za4 + " | " + zb4 + " | " + zc4	+ " | " + zd4 + " | " + ze4 + " | " + zf4 + " | " + zg4 + " | " + zh4 + " | " + zi4 + " | " + zj4+ " |   4 ");
	    System.out.println("     =========================================     |     =========================================     ");
	    System.out.println(" 5   | " + a5 + " | " + b5 + " | " + c5 + " | " + d5 + " | " + e5 + " | " + f5 + " | " + g5 + " | " + h5 + " | " + i5 + " | " + j5 + " |   5 | 5   | " +	za5 + " | " + zb5 + " | " + zc5 + " | " + zd5 + " | " + ze5 + " | " + zf5 + " | " + zg5 + " | " + zh5 + " | " + zi5 + " | " + zj5 + " |   5 ");
	    System.out.println("     =========================================     |     =========================================     ");
	    System.out.println(" 6   | " + a6 + " | " + b6 + " | " + c6 + " | " + d6 + " | " + e6 + " | " + f6 + " | " + g6 + " | " + h6 + " | " + i6 + " | " + j6 + " |   6 | 6   | " +	za6 + " | " + zb6 + " | " + zc6 + " | " + zd6 + " | " + ze6 + " | " + zf6 + " | " + zg6 + " | " + zh6 + " | " + zi6 + " | " + zj6+ " |   6 ");
	    System.out.println("     =========================================     |     =========================================     ");
	    System.out.println(" 7   | " + a7 + " | " + b7 + " | " + c7 + " | " + d7 + " | " + e7 + " | " + f7 + " | " + g7 + " | " + h7 + " | " + i7 + " | " + j7 + " |   7 | 7   | " +	za7 + " | " + zb7 + " | " + zc7 + " | " + zd7 + " | " + ze7 + " | " + zf7 + " | " + zg7 + " | " + zh7 + " | " + zi7 + " | " + zj7+ " |   7 ");
	    System.out.println("     =========================================     |     =========================================     ");
	    System.out.println(" 8   | " + a8 + " | " + b8 + " | " + c8 + " | " + d8 + " | " + e8 + " | " + f8 + " | " + g8 + " | " + h8 + " | " + i8 + " | " + j8 + " |   8 | 8   | " +	za8 + " | " + zb8 + " | " + zc8 + " | " + zd8 + " | " + ze8 + " | " + zf8 + " | " + zg8 + " | " + zh8 + " | " + zi8 + " | " + zj8+ " |   8 ");
	    System.out.println("     =========================================     |     =========================================     ");
	    System.out.println(" 9   | " + a9 + " | " + b9 + " | " + c9 + " | " + d9 + " | " + e9 + " | " + f9 + " | " + g9 + " | " + h9 + " | " + i9 + " | " + j9 + " |   9 | 9   | " +	za9 + " | " + zb9 + " | " + zc9 + " | " + zd9 + " | " + ze9 + " | " + zf9 + " | " + zg9 + " | " + zh9 + " | " + zi9 + " | " + zj9+ " |   9 ");
	    System.out.println("     =========================================     |     =========================================     ");
	    System.out.println(" 10  | " + a10 + " | " + b10 + " | " + c10 + " | " + d10 + " | " + e10 + " | " + f10 + " | " + g10 + " | " + h10 + " | " + i10 + " | " + j10 + " |  10 | 10  | " +	za10 + " | " + zb10 + " | " + zc10 + " | " + zd10 + " | " + ze10 + " | " + zf10 + " | " + zg10 + " | " + zh10 + " | " + zi10 + " | " + zj10+ " |   10 ");
	    System.out.println("     =========================================     |     =========================================     ");
	    System.out.println("       A   B   C   D   E   F   G   H   I   J       |       A   B   C   D   E   F   G   H   I   J       ");
	    System.out.println("      Key:      O: Ship     X: Ship Hit    -: Missed shot     Blank spaces have yet to be explored");
	    System.out.println(" ");
	}
	
	public static void clearDisplay() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	public static void delay() {
		clearDisplay();
		System.out.println("Press ENTER to contine......");
		try {
			System.in.read();
		} catch (IOException e) {
		}
		clearDisplay();
		
	}
}
