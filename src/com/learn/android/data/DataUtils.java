/**
 * com.yiban.data DataUtils.java
 * 2014-10-10 下午7:40:02
 * JUN JUN
 */
package com.learn.android.data;

import org.json.JSONObject;

import android.util.Log;

/**
 * 
 * DataUtils.java
 * @author JUN
 * 说明：数据通讯加密和解密的工具类
 * 2015-4-13上午10:47:32
 */
public final class DataUtils {
	public static final String TAG="DataUtils";
	//第一对公钥
	private static final String DEFAULT_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDosvH1gCpQTTZLXGMcSeeqDjWuDVY0+Aab1VbtGJqWdkPd32D4hEUwFjVJ+FJbq7UpvFFDQ3k2y2n/1rzxWapFk/e+BNNCSKP9e6+Of1SLs83So27dgiAeAKmdQoxwfXrgvP1/QRMJJ0i6m3CRRyTlXO+cMGbYqRv1iTT9uaRolQIDAQAB";
//	private static final String DEFAULT_PRIVATE_KEY = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAOiy8fWAKlBNNktcYxxJ56oONa4NVjT4BpvVVu0YmpZ2Q93fYPiERTAWNUn4UlurtSm8UUNDeTbLaf/WvPFZqkWT974E00JIo/17r45/VIuzzdKjbt2CIB4AqZ1CjHB9euC8/X9BEwknSLqbcJFHJOVc75wwZtipG/WJNP25pGiVAgMBAAECgYEAv4PXY8hyCtkhYHDPGU8yHWHIiFFtq/ad6c9x1X00bbU0Mf1Q3/hswSDmBtUbY1s0pP7amtODhbdwrCFeK/0yBrOegb2fQeJs/QL6/y4/DPzRB21k9N8cQjgmv5tQb72fwdY8nDROXnzKQceMo6b/xkWaIhvhdUq6nCqPvoIGRIECQQD+lOKTQk769G9BQd7HW+2H2NioPbxri+V27daC1M5uBfBj8Wt3NDJ5IyMvOHz5yTlm8FsE2Zz1/aFdLJ/Rv4IRAkEA6f7ZOMcuxlRsAiN708+r3q3sxAyBood+qAJ1MKhOrdR94RcAPUkcjFTZ8j1v0eclj6+w2RChcpb5Ath93ia6RQJBAP3b6x+axHUcn4A8NfEn6vFGu6zwet3nT3bLbddia0JtK6wNhfMFGruO3TvuITlXfaT3UlvAv/LP6kOmBuw6AnECQQDR3r29awjM4ZMuJ908EJs6Ugx1mjH7MEOtNOcfCRXoWxm79QFF9nkgdEo2NlxAi2zo/s9DIONs/3O/1aSux1VxAkBkkOdc0f2ogWZHqtCYfVfYjwbMvlW/6lnbq0B76V1SVqogoSubwnF7EUBdmqpzWmzqM4xURBh9QqDnUUfBzPMW";
//	private static final String DEFAULT_PRIVATE_KEY="";
	//第二队私钥
	private static final String DEFAULT_PRIVATE_KEY = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBALqQ5cQ8cus/r3kKjv+W9S0p4Bj9AaZpmE+iLtSKlQmrtV7TQj9qHOy7y20HN8LGaMJE9cbUWw1Fc/TA3gEbrSKodHdRQgcXhd+kBXzXqRaqMbnTekgkANMHkFUt/qpH95BNeC9hw+tMDef6MLF38N2xptbvYc1ADIo9Qj0hF4GjAgMBAAECgYEAjFxbIQpBg0/EmpIhB5XxG2t32BTxWtvy5WalSO6CNmZi69aQ7tjMriaTY5GcmANh6VasekxlvFRWavt3iunhlPmzHa/KNEJrdJZYsd8metAG07NEva7XqzMCWaHnp/uijF9wtpHoFNw346baBYFYMlKNzwrDAPjCNsF6Cdu39DECQQDs4CRxe93eafjmzp1wfg9P6HTyRyoZ4g+TocTiXKeId81NERBDtkUpO329pvOFuv1O+tkya1ZMPb3opCqmAPi3AkEAyaDu6Wk+Wf88Y3J/SczIVClUMh708PkhlNzAZLbXhcgDtIU0TuWakQkD8u04WOFCCK6pd8s3VH0BP+rzCfbadQJBANK1G5XbQmRLTf46ArCDYimJtSWjCh9WCNchSlq1Ys2xC+2m5RnmdCUWZ2ahsPPfft6Xo0cHVg+hyGG+TrW2HYcCQF9SNQCmH7MeZmdBbwntxVt8enCDkBsIPKcKwe4bPsLhb1b9jmAqTit5DqPfID9spvJB2J5otUy9GEUmhyXTzS0CQQCFgFpAqIf5XzIeVucjQb7WyycE3LYmflS0hHWrVJ5MUc29GafIuwBiLEjo//qt3A2T0wjIuyGb/xovQTsi8uAJ";
	
	public static String encodeRequest(JSONObject json) throws Exception{
		byte[] data = json.toString().getBytes();
		byte[] encodedData = RSAUtils.encryptByPublicKey(data, DEFAULT_PUBLIC_KEY);
		return Base64Utils.encode(encodedData);
		
	}
	
	
	public static String decodeAppResponse(String response) throws Exception{
		Log.i(TAG,"需要解密的字符串"+response);
		byte[] responseData = Base64Utils.decode(response);
		byte[] decodedData = RSAUtils.decryptByPrivateKey(responseData,
				DEFAULT_PRIVATE_KEY);
		String responseText = new String(decodedData);
		return responseText;
	}
	
	
	
	
	
	
	
	
	
	
	
}
