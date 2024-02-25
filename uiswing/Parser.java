import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.stream.Stream;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Parser {
    private String filePath;
    public Parser(String filePath){
        this.filePath = filePath;
    }

    /**
     * 按行来读是不行的，并不是一行一条消息
     * 解析时间来分割, [...]...
     */
    public List<Chat> parse() {
        List<Chat> chats = new ArrayList();
        try{
            String content = Files.readString(Paths.get(this.filePath));
            Matcher matcher = Pattern.compile("\\[.+\\][^\\[]+").matcher(content);
            int chatsCount = 0; // 消息条数
            int lastEnd = 0; // 上一条消息的终点
            while (matcher.find()) {
                chatsCount++;
                // System.out.format("found index: %s, start: %d, end: %d, content:%n%s%n", chatsCount, matcher.start(), matcher.end(), matcher.group());
                if(lastEnd != matcher.start()){
                    throw new Error("分割消息的正则表达式不完备");
                }else{
                    lastEnd = matcher.end();
                }

                chats.add(this.parseChat(chatsCount, matcher.group()));

                
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return chats;
    }

    // [2023/12/12, 19:05:37] Michael Pan: ¿Tienes novio?
    private Chat parseChat(int id, String str){
        String dateTime, userName, content;
        // 匹配日期时间
        Matcher m1 = Pattern.compile("\\[.+\\]").matcher(str);
        if(m1.find()){
            dateTime = str.substring(m1.start()+1, m1.end()-1).trim();
            // System.out.format("%d,%d,%s%n", m1.start(), m1.end(), dateTime);
        }else{
            throw new Error("匹配日期时间的正则表达式不完备");
        }
        // 匹配发消息的人
        str = str.substring(m1.end());
        Matcher m2 = Pattern.compile("[^:]+").matcher(str);
        if(m2.find()){
            userName = str.substring(m2.start()+1, m2.end()).trim();
            // System.out.format("%d,%d,%s%n", m2.start(), m2.end(), userName);
        }else{
            throw new Error("匹配发消息人的正则表达式不完备");
        }
        // 消息内容
        content = str.substring(m2.end()+1).trim();
        // System.out.println(content);
        Chat chat = new Chat(id, dateTime, userName, content);

        try{
            System.out.println(chat);
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        return chat;
    }
}
