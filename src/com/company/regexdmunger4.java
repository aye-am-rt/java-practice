package com.company;
//
//			try{
//				String regexInt = "[0-9]+";
//				Pattern pInt = Pattern.compile(regexInt, Pattern.CASE_INSENSITIVE);
//				Matcher mInt = pInt.matcher(EachData[i]);
//				if(mInt.matches())
//				{
//					TypeArray[i]="java.lang.Integer";
//				}
//				try{
//					String regexFloat = "^[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?$";
//					Pattern pFloat = Pattern.compile(regexFloat, Pattern.CASE_INSENSITIVE);
//					Matcher mFloat = pFloat.matcher(EachData[i]);
//					if(mFloat.matches())
//					{
//						TypeArray[i]="java.lang.Integer";
//					}
//					try{
//						String regexDate1 = "^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$";
//						Pattern pDate1 = Pattern.compile(regexDate1, Pattern.CASE_INSENSITIVE);
//						Matcher mFDate1 = pDate1.matcher(EachData[i]);
//						if(mFDate1.matches())
//						{
//							TypeArray[i]="java.util.Date";
//						}
//						else if(EachData[i].isEmpty()) {
//							TypeArray[i] = "java.lang.Object";
//						}
//						else
//						{
//							TypeArray[i]="java.lang.String";
//						}
//					}catch (DateTimeException ex){}
//				}catch (NumberFormatException ex){}
//			}catch (NumberFormatException ex) {}
//
//		}
//		DataTypeDefinitions dtd = new DataTypeDefinitions();
//		dtd.setDataTypeArray(TypeArray);
//		return dtd;
//
//		// checking for Integer  \b([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\b
//
//		// checking for floating point numbers  ^[-+]?[0-9]*\.?[0-9]+([eE][-+]?[0-9]+)?$.
//
//
//		// checking for date format dd/mm/yyyy   ^\d{1,2}\/\d{1,2}\/\d{4}$
//
//		// checking for date format mm/dd/yyyy
//	/*	To match a date in mm/dd/yyyy format, rearrange the regular expression to
//		^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\d\d$*/
//
//
//	/*
//^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579]
//		[26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$
//    */
//
//		// checking for date format dd-month-yyyy
///*		For dd-mm-yyyy format, use ^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\d\d$  */
//
//		// checking for date format yyyy-mm-dd
///*		^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$
//        matches a date in yyyy-mm-dd format from 1900-01-01 through 2099-12-31,with a choice of four separators*/
