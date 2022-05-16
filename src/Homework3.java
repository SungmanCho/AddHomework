import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Homework3 {

    static int totalPage = 127;
    static int pageBlock = 10;

    static int pageIndex;

    static int currentBlock() {
        return (pageIndex -1) / pageBlock;
    }

    static int lastIndex() {
        return (int)(Math.ceil(totalPage / pageBlock)) + 1;
    }

    static int firstNo(){
        return currentBlock() * pageBlock;
    }

    static int lastNo(){
        return currentBlock() * pageBlock + pageBlock;
    }

    static void print() {

        StringBuffer pageNavigation = new StringBuffer();

        pageNavigation.append("<a href=\"#\">[처음]</a> ");
        pageNavigation.append("<a href=\"#\">[이전]</a> ");

        for(int i = firstNo()+1; i < lastNo()+1; i++) {

            if (i > lastIndex()) { break; }

            if (i == pageIndex) {
                pageNavigation.append("<a href=\"#\" style=\"color:red;\">"+ i +"</a> ");
            } else if (i != pageIndex) {
                pageNavigation.append("<a href=\"#\">"+ i +"</a> ");
            }
        }

        pageNavigation.append("<a href=\"#\">[다음]</a> ");
        pageNavigation.append("<a href=\"#\">[마지막]</a><br>\r\n");


        System.out.println(pageNavigation.toString());
    }



    public static void main(String[] args) {

        pageIndex = 1;
        for(int i = pageIndex; i <= lastIndex(); i++) {
            print();
            pageIndex++;
        }
    }
}
