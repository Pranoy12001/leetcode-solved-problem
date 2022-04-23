public class Codec {
    Map<String, String> codeMap = new HashMap<>();
    Map<String, String> urlMap = new HashMap<>();
    public static final String chars = 
        "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public String getCode() {
        int[] codes = new int[6];
        
        for (int i = 0; i < 6; i++) {
            codes[i] = chars.charAt((int) Math.random() * 62);
        }
        
        return "http://tinyurl.com/" + String.valueOf(codes);
    }
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (urlMap.containsKey(longUrl)) {
            return urlMap.get(longUrl);
        }
        
        String code = getCode();
        
        while (codeMap.containsKey(code)) {
            code = getCode();
        }
        
        urlMap.put(longUrl, code);
        codeMap.put(code, longUrl);
        
        return code;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return codeMap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));