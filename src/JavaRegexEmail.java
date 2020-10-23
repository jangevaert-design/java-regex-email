import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRegexEmail {

  public static void main(String[] args) {

    List<String> emails = List.of("luke@gmail.com",
        "andy@yahoocom", "34234sdfa#2345", "f344@gmail.com");

    String regex = "[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,18}";

    Pattern p = Pattern.compile(regex);

    for (String email: emails) {

      Matcher m = p.matcher(email);
      if (m.matches()) {
        System.out.printf("%s matches%n", email);
      } else {
        System.out.printf("%s does not match%n", email);
      }
    }
  }
}

//  The email is divided into five parts. [a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\.[a-zA-Z.]{2,18}

//  [a-zA-Z0-9._-]+
//  The first part is the local part. This is usually a name of a company, individual,
//  or a nickname. The [a-zA-Z0-9._-]+ lists all possible characters, we can use in the local part.
//  They can be used one or more times.
//
//  @
//  The second part consists of the literal @ character.
//
//  [a-zA-Z0-9-]+
//  The third part is the domain part.
//  It is usually the domain name of the email provider, like yahoo, or gmail.
//  The [a-zA-Z0-9-]+ is a character set providing all characters that can be used in the
//  domain name. The + quantifier makes use of one or more of these characters.
//
//  \.
//  The fourth part is the dot character. It is preceded by the escape character (\).
//  This is because the dot character is a metacharacter and has a special meaning.
//  By escaping it, we get a literal dot.
//
//   [a-zA-Z.]{2,18}
//   The final part is the top level domain: [a-zA-Z.]{2,18}.
//   Top level domains can have from 2 to 18 characters, such as sk, net, info, travel,
//   cleaning, travelinsurance.
//   The maximum length can be 63 characters, but most domain are shorter than 18 characters today.
//   There is also a dot character. This is because some top level domains have two parts;
//   for example co.uk.