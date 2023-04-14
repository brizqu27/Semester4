
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class tugas {

    private static enum Token {
        NOTEQUALTO("[!][=]"),
        OR("\\|"),
        ARRAYSIZE("[a-zA-z]+\\[[0-9]+\\]"),
        ARRAYSIZEVAR("[a-zA-Z]+\\[[a-zA-Z]+\\]"),
        ARRAYMULTI("[a-zA-Z]+\\[[\\[\\]]+\\]"),
        ARRAY("[a-zA-z]+\\=[a-zA-Z]+\s[a-zA-Z]+\\(\\)"),
        KONTINYU("-?[0-9]+\\.[0-9]+"),
        NUMBER("-?[0-9]+"),
        OPERATOR("[|/|+|%|*|\\-|]"),
        SKIP("[\t\f\r\n]+"),
        STRING ("\"[-a-zA-Z0-9+]\""),
        LITERALBOOLEAN("TRUE|FALSE"),
        TIPEDATA("INT |STRING |DOUBLE "),
        VARIABLE("[|A-Z|a-z|a-z0-9|a-z[0-9]+\\.[0-9]+]+"),
        NOT("!") ,
        AND("&"),
        EXCLUSIVEOR("\\^"),
        SHIFTRIGHTZERO("[>][>][>]"),
        SHIFTRIGHT("[>][>]"),
        SHIFTLEFT("[<][<]"),
        GREATHERTHANOREQUALTO("[>][=]"),
        LESSTHANOREQUALTO("[<][=]"),
        GREATHERTHAN(">"),
        LESSTHAN("<"),
        EQUALTO("[=][=]");

        private final String pattern;

        private Token(String pattern) {
            this.pattern = pattern;
        }
    }

    private static class Word {
        private final Token token;
        private final String lexeme;

        private Word(Token token, String lexeme) {
            this.token = token;
            this.lexeme = lexeme;
        }

        @Override
        public String toString() {
            return String.format("%-15s => [%s]", token.name(), lexeme);
        }
    }

    private static ArrayList<Word> lex(String input) {
        // The tokens to return
        ArrayList<Word> words = new ArrayList<>();

        // Lexer logic begins here
        StringBuilder tokenPatternsBuffer = new StringBuilder();
        for (Token token : Token.values())
            tokenPatternsBuffer.append(String.format("|(?<%s>%s)", token.name(), token.pattern));
        Pattern tokenPatterns = Pattern.compile(tokenPatternsBuffer.substring(1));

        // Begin matching tokens
        Matcher matcher = tokenPatterns.matcher(input);
        while (matcher.find()) {
            for (Token token : Token.values())
                if (matcher.group(token.name()) != null) {
                    words.add(new Word(token, matcher.group(token.name())));
                }
        }
        return words;
    }

    public static void main(String[] args) {
        String input = "STRING = \"SAYA\" INT a = 2 * 2.85 / 5 \t DOUBLE b = 2.50 + 30 - 2 \t FALSE angka[123] aku[kamu] string[][] bcd=new\sarray() \"STRING\" 1+1*1 | & ! ^ >> << >>> >= <= > < == != % / * ";

        ArrayList<Word> words = lex(input);
        words.forEach((word) -> {
            System.out.println(word);
        });
    }

}