import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class grafos {
public List <String> letras = new ArrayList<>();
public static List <nodo> nodes = new ArrayList<>();
public static List <arista> aristas = new ArrayList<>();
public static Stack<String> ruta = new Stack<>();
public static Stack <String> enRuta = new Stack<>();
public static Stack <String> camino = new Stack<>();
public static BufferedReader br = null;
public static final String QUOTE ="\"";
public static int count = 0;
public static arista actual;
public static Stack <arista> result = new Stack<>();


public static void main(String [] args) throws IOException {
    grafos g = new grafos("/Users/abraham98/Desktop/aristas.csv");


    System.out.println("escribe 1 para menu");
    int num = 0;
    Scanner scan = new Scanner(System.in);
    num = scan.nextInt();
    while(num == 1){
        System.out.println("nodo1");
        String nodo1 = scan.next();
        System.out.println("nodo2");
        String nodo2 = scan.next();
        buscar(aristas,nodo1,nodo2);
        num = 0;
    }

}

public grafos(String filePath) throws IOException{

    br = new BufferedReader(new FileReader(filePath));
    String line = br.readLine();
    while (null!=line){
        String [] fields = line.split(",");
        fields = removeQuotes(fields);
        if(nodes.isEmpty()){
            addNodes(fields);
        }else{
            for (int i = 0;i<fields.length; i++){
                if(fields[i].equals("1")){
                    arista ar = new arista();
                    ar.nodo1 = nodes.get(count);
                    ar.nodo2 = nodes.get(i);
                    aristas.add(ar);
                }
            }
            count+=1;
        }
        line = br.readLine();
    }
}

    @Override
    public String toString() {
        return "G={"+nodes+","+ aristas +"}";
    }

    private static void buscar(List <arista> aristas, String o, String d){
    Stack<arista> visitados = new Stack<>();
    Stack<arista>  porVisitar = new Stack<>();
        for (arista a: aristas) {
            if(a.getNodo1().getNombre().equals(o)){
                porVisitar.push(a);
            }
        }
        while(!porVisitar.isEmpty()){
            actual = porVisitar.pop();
            visitados.push(actual);
            if (actual.getNodo2().getNombre().equals(d)){
                break;
            }
            for (arista a: aristas) {
                if(a.getNodo1().equals(actual.getNodo2())
                        && !porVisitar.contains(a)
                        && !visitados.contains(a)
                ){
                    porVisitar.push(a);
                }
            }
        }
        actual = visitados.pop();
        result.push(actual);
        while (!visitados.isEmpty()){
            if(actual.getNodo1().equals(visitados.peek().getNodo2())){
                actual = visitados.pop();
                result.push(actual);
            }else{
                visitados.pop();
            }
        }
        while(!result.isEmpty()){
            System.out.println(result.pop());
        }
}

private static String [] removeQuotes(String[] fields){
    String [] result = new String[fields.length];
    for (int i = 0; i<result.length; i++){
        result[i] = fields[i].replaceAll(QUOTE," ").replaceAll(QUOTE+"$","");
    }
    return result;
}
private static void addNodes(String [] letras) {
    for (int i = 0; i < letras.length; i++) {
        nodo n = new nodo(letras[i]);
        nodes.add(n);
        System.out.println(nodes.get(i));


    }

}
}
