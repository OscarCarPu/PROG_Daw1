package ejercicio1;

public class App{
    public static void main(String[] args){
        String json_Example = """
            {
                "title":"JSON Example",
                "id":1,
                "tests":[
                    {
                        "title":"test1",
                        "description":"description12"
                    },
                    {
                        "title":"test2",
                        "description":"another test"
                    }
                ]
            }
        """;
        String xml = """
            <root>
                <element id="1">
                    <title>This is the elemtn1</title>
                    <value>120</value>
                    <symbol>/"·</symbol>
                </element>
                <element id="2">
                    <title>This is the element2</title>
                    <value>123,123.23</value>
                    <symbol>/"·"!</symbol>
                </element
                <element id="3"/>
            </root>
        """;
        System.out.println("JSON example");
        System.out.println(json_Example);
        System.out.println("XML example");
        System.out.println(xml);
    }
}