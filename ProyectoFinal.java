import java.util.*;

class Estado{
    private String id;  // Identificador String
    private int idNum;  // Identificador Numérico
    private boolean esFinal;    // 0 = No, 1 = Si
    private boolean esInicial;  // 0 = No, 1 = Si
    private int ConjuntoPerteneciente;  // Clase a que pertenece (ver más en Marcar/CrearClases)

    public void setId(String id) { this.id = id; }
    public void setIdNum(int idNum) { this.idNum = idNum; }
    public void setEsFinal(boolean esFinal) { this.esFinal = esFinal; }
    public void setEsInicial(boolean esInicial) { this.esInicial = esInicial; }
    public void setConjuntoPerteneciente(int conjunto) { this.ConjuntoPerteneciente = conjunto;}

    public String getId() { return id; }
    public int getIdNum() { return idNum; }
    public boolean getEsFinal() { return esFinal; }
    public boolean getEsInicial() { return esInicial; }
    public int getConjuntoPerteneciente() { return ConjuntoPerteneciente; }

    // Cosntructor por String
    public Estado(String id){
        setId("Q"+id);
        setIdNum(Integer.parseInt(id));
        setEsFinal(false);
        if(id.equals("0"))
            setEsInicial(true);
        else
            setEsInicial(false);
    }

    public String toString(){
        return String.format("%s", this.id);
    }
}

class Agudas{
    private List<Estado> estados = new ArrayList<>();
    private List<String> alfabeto = new ArrayList<>();
    private List<List<Estado>> table = new ArrayList<>();

    public void setEstados(List<Estado> estados) { this.estados = estados; }
    public void setAlfabeto(List<String> alfabeto) { this.alfabeto = alfabeto; }


    // Cosntructor que toma el alfabeto y los estados que existan
    Agudas(List<String> alfabeto, List<Estado> estados){
        setAlfabeto(alfabeto);
        setEstados(estados);
    }

    // Crear matriz de transicciones
    void createTransitions(Scanner scanner, List<Estado> ListEstados){
        for(int i=0; i < estados.size(); i++) {
            table.add(new ArrayList<>());
        }

        String inputBuffer;
        int flag, indexOfEstado = 0;

        // Inicializar cada fila de la matriz
        for(int i=0; i < estados.size(); i++) {
            table.add(new ArrayList<>());
        }

        // Crear una copia de todos los estados
        List<String> ListEstadosID = new ArrayList<>();
        for (int i=0; i<ListEstados.size(); i++){
            ListEstadosID.add(ListEstados.get(i).getId());
        }

        // Agregando todas las transiciones...
        //////////////////////////////////////// R0 = P0
        table.get(0).add(estados.get(1));	// a
        table.get(0).add(estados.get(1));	// e
        table.get(0).add(estados.get(1));	// o
        table.get(0).add(estados.get(2));	// i
        table.get(0).add(estados.get(2));	// u

        table.get(0).add(estados.get(5));	// á
        table.get(0).add(estados.get(5));	// é
        table.get(0).add(estados.get(5));	// ó
        table.get(0).add(estados.get(6));	// í
        table.get(0).add(estados.get(6));	// ú

        table.get(0).add(estados.get(0));	// n
        table.get(0).add(estados.get(0));	// s
        table.get(0).add(estados.get(0));	// y
        table.get(0).add(estados.get(0));	// C - {n, s, y}

        table.get(0).add(estados.get(3));	// -

        //////////////////////////////////////// R1 = P1
        table.get(1).add(estados.get(1));	// a
        table.get(1).add(estados.get(1));	// e
        table.get(1).add(estados.get(1));	// o
        table.get(1).add(estados.get(1));	// i
        table.get(1).add(estados.get(1));	// u

        table.get(1).add(estados.get(3));	// á
        table.get(1).add(estados.get(3));	// é
        table.get(1).add(estados.get(3));	// ó
        table.get(1).add(estados.get(3));	// í
        table.get(1).add(estados.get(3));	// ú

        table.get(1).add(estados.get(4));	// n
        table.get(1).add(estados.get(3));	// s
        table.get(1).add(estados.get(8));	// y
        table.get(1).add(estados.get(8));	// C - {n, s, y}

        table.get(1).add(estados.get(3));	// -

        //////////////////////////////////////// R2 = P2
        table.get(2).add(estados.get(1));	// a
        table.get(2).add(estados.get(1));	// e
        table.get(2).add(estados.get(1));	// o
        table.get(2).add(estados.get(1));	// i
        table.get(2).add(estados.get(1));	// u

        table.get(2).add(estados.get(5));	// á
        table.get(2).add(estados.get(5));	// é
        table.get(2).add(estados.get(5));	// ó
        table.get(2).add(estados.get(3));	// í
        table.get(2).add(estados.get(3));	// ú

        table.get(2).add(estados.get(4));	// n
        table.get(2).add(estados.get(3));	// s
        table.get(2).add(estados.get(8));	// y
        table.get(2).add(estados.get(8));	// C - {n, s, y}

        table.get(2).add(estados.get(3));	// -

        //////////////////////////////////////// R3 = P5, P12
        table.get(3).add(estados.get(3));	// a
        table.get(3).add(estados.get(3));	// e
        table.get(3).add(estados.get(3));	// o
        table.get(3).add(estados.get(3));	// i
        table.get(3).add(estados.get(3));	// u

        table.get(3).add(estados.get(3));	// á
        table.get(3).add(estados.get(3));	// é
        table.get(3).add(estados.get(3));	// ó
        table.get(3).add(estados.get(3));	// í
        table.get(3).add(estados.get(3));	// ú

        table.get(3).add(estados.get(3));	// n
        table.get(3).add(estados.get(3));	// s
        table.get(3).add(estados.get(3));	// y
        table.get(3).add(estados.get(3));	// C - {n, s, y}

        table.get(3).add(estados.get(3));	// -

        //////////////////////////////////////// R4 = P11
        table.get(4).add(estados.get(3));	// a
        table.get(4).add(estados.get(3));	// e
        table.get(4).add(estados.get(3));	// o
        table.get(4).add(estados.get(3));	// i
        table.get(4).add(estados.get(3));	// u

        table.get(4).add(estados.get(3));	// á
        table.get(4).add(estados.get(3));	// é
        table.get(4).add(estados.get(3));	// ó
        table.get(4).add(estados.get(3));	// í
        table.get(4).add(estados.get(3));	// ú

        table.get(4).add(estados.get(3));	// n
        table.get(4).add(estados.get(7));	// s
        table.get(4).add(estados.get(3));	// y
        table.get(4).add(estados.get(3));	// C - {n, s, y}

        table.get(4).add(estados.get(3));	// -

        //////////////////////////////////////// R5 = P3, P8
        table.get(5).add(estados.get(3));	// a
        table.get(5).add(estados.get(3));	// e
        table.get(5).add(estados.get(3));	// o
        table.get(5).add(estados.get(6));	// i
        table.get(5).add(estados.get(6));	// u

        table.get(5).add(estados.get(3));	// á
        table.get(5).add(estados.get(3));	// é
        table.get(5).add(estados.get(3));	// ó
        table.get(5).add(estados.get(3));	// í
        table.get(5).add(estados.get(3));	// ú

        table.get(5).add(estados.get(7));	// n
        table.get(5).add(estados.get(7));	// s
        table.get(5).add(estados.get(3));	// y
        table.get(5).add(estados.get(3));	// C - {n, s, y}

        table.get(5).add(estados.get(3));	// -

        //////////////////////////////////////// R6 = P4, P9
        table.get(6).add(estados.get(3));	// a
        table.get(6).add(estados.get(3));	// e
        table.get(6).add(estados.get(3));	// o
        table.get(6).add(estados.get(3));	// i
        table.get(6).add(estados.get(3));	// u

        table.get(6).add(estados.get(3));	// á
        table.get(6).add(estados.get(3));	// é
        table.get(6).add(estados.get(3));	// ó
        table.get(6).add(estados.get(3));	// í
        table.get(6).add(estados.get(3));	// ú

        table.get(6).add(estados.get(7));	// n
        table.get(6).add(estados.get(7));	// s
        table.get(6).add(estados.get(3));	// y
        table.get(6).add(estados.get(3));	// C - {n, s, y}

        table.get(6).add(estados.get(3));	// -

        //////////////////////////////////////// R7 = P6, P10
        table.get(7).add(estados.get(3));	// a
        table.get(7).add(estados.get(3));	// e
        table.get(7).add(estados.get(3));	// o
        table.get(7).add(estados.get(3));	// i
        table.get(7).add(estados.get(3));	// u

        table.get(7).add(estados.get(3));	// á
        table.get(7).add(estados.get(3));	// é
        table.get(7).add(estados.get(3));	// ó
        table.get(7).add(estados.get(3));	// í
        table.get(7).add(estados.get(3));	// ú

        table.get(7).add(estados.get(3));	// n
        table.get(7).add(estados.get(3));	// s
        table.get(7).add(estados.get(3));	// y
        table.get(7).add(estados.get(3));	// C - {n, s, y}

        table.get(7).add(estados.get(3));	// -

        //////////////////////////////////////// R8 = P7
        table.get(8).add(estados.get(3));	// a
        table.get(8).add(estados.get(3));	// e
        table.get(8).add(estados.get(3));	// o
        table.get(8).add(estados.get(3));	// i
        table.get(8).add(estados.get(3));	// u

        table.get(8).add(estados.get(3));	// á
        table.get(8).add(estados.get(3));	// é
        table.get(8).add(estados.get(3));	// ó
        table.get(8).add(estados.get(3));	// í
        table.get(8).add(estados.get(3));	// ú

        table.get(8).add(estados.get(3));	// n
        table.get(8).add(estados.get(7));	// s
        table.get(8).add(estados.get(3));	// y
        table.get(8).add(estados.get(3));	// C - {n, s, y}

        table.get(8).add(estados.get(3));	// -
    }

    // Recibe una cadena a evaluar con las reglas establecidas
    void evaluarCadena(String cadena){
        String estadoActual, caminoActual;  // Indicadores para buscar el estado en done acabe la cadena
        int indexEstado = 0, indexCamino = 0;   // Coordenadas dentro de la tabla de transiciones
        String[] cadenaPorLetra;    // Cedan separada por letra

        estadoActual = estados.get(0).getId(); //El estado inicial va ser el primer estado dentro del conjunto de los estados

        cadenaPorLetra = cadena.split("(?!^)"); //Dividir cadena por letra y guardarlo en un arreglo
        String[][] transiciones = new String[estados.size()][alfabeto.size()];

        // Tabla de transiciones con puros ID en String
        for (int i = 0; i < transiciones.length; i++) {
            for (int j = 0; j < transiciones[0].length; j++) {
                transiciones[i][j] = table.get(i).get(j).getId();
            }
        }

        // Evaluar cada elemento de la cadena
        for (int i = 0; i < cadena.length(); i++) {
            if (!alfabeto.contains(cadenaPorLetra[i])) {  //Si una letra de al cadena no pertence al alfabeto, se rechaza la cadena
                System.out.printf("Elemento '%s' no pertenece al alfabeto\n", cadenaPorLetra[i]);
                estadoActual = "Invalid";
                break;
            }
            caminoActual = cadenaPorLetra[i]; //caminoActual toma el indice de la letra
            //Encontrar index del estadoActual
            for (int indexOnStatus = 0; indexOnStatus < estados.size(); indexOnStatus++)
                if (estadoActual.equals(estados.get(indexOnStatus).getId())) indexEstado = indexOnStatus;
            //Encontrar index del camino
            for (int indexOnPath = 0; indexOnPath < alfabeto.size(); indexOnPath++) {
                if (caminoActual.equals(alfabeto.get(indexOnPath))) indexCamino = indexOnPath;
            }
            //El nuevo estado es dado por los dos indice encontrados
            estadoActual = transiciones[indexEstado][indexCamino];
        }

        // Verificamos si el estadoActual termino siendo uno FINAL
        int flag = 0;
        for (int i = 0; i < estados.size(); i++) {
            if(estados.get(i).getEsFinal())
                if(estados.get(i).getId().equals(estadoActual))
                    flag = 1;
        }

        if(flag == 1){
            System.out.println("¡La palabra esta bien escrita!");
        }
        else
            System.out.println("Existe un error de acentuación.");

    }

    public String toString(){
        String result = "";
        for(int i = 0; i < table.size(); i++){
            for(int j = 0; j < table.get(i).size(); j++){
                result += table.get(i).get(j) + " ";
            }
            result += "\n";
        }
        return result;
    }
}

class Graves{
    private List<Estado> estados = new ArrayList<>();
    private List<String> alfabeto = new ArrayList<>();
    private List<List<Estado>> table = new ArrayList<>();

    public void setEstados(List<Estado> estados) { this.estados = estados; }
    public void setAlfabeto(List<String> alfabeto) { this.alfabeto = alfabeto; }

    public List<Estado> getEstados() { return estados; }
    public List<String> getAlfabeto() { return alfabeto; }
    public List<List<Estado>> getTransiciones() { return table; }

    // Cosntructor que toma el alfabeto y los estados que existan
    Graves(List<String> alfabeto, List<Estado> estados){
        setAlfabeto(alfabeto);
        setEstados(estados);
    }

    // Crear matriz de transicciones con datos
    void createTransitions(Scanner scanner, List<Estado> ListEstados){
        for(int i=0; i < estados.size(); i++) {
            table.add(new ArrayList<>());
        }

        String inputBuffer;
        int flag, indexOfEstado = 0;

        // Inicializar cada fila de la matriz
        for(int i=0; i < estados.size(); i++) {
            table.add(new ArrayList<>());
        }

        // Crear una copia de todos los estados
        List<String> ListEstadosID = new ArrayList<>();
        for (int i=0; i<ListEstados.size(); i++){
            ListEstadosID.add(ListEstados.get(i).getId());
        }

        // Agregando todas las transiciones...
        //////////////////////////////////////// R0 = P0
        table.get(0).add(estados.get(2));	// a
        table.get(0).add(estados.get(2));	// e
        table.get(0).add(estados.get(2));	// o
        table.get(0).add(estados.get(3));	// i
        table.get(0).add(estados.get(3));	// u

        table.get(0).add(estados.get(4));	// á
        table.get(0).add(estados.get(4));	// é
        table.get(0).add(estados.get(4));	// ó
        table.get(0).add(estados.get(5));	// í
        table.get(0).add(estados.get(5));	// ú

        table.get(0).add(estados.get(0));	// n
        table.get(0).add(estados.get(0));	// s
        table.get(0).add(estados.get(0));	// y
        table.get(0).add(estados.get(0));	// C - {n, s, y}

        table.get(0).add(estados.get(1));	// -

        //////////////////////////////////////// R1 = P1, P17
        table.get(1).add(estados.get(1));	// a
        table.get(1).add(estados.get(1));	// e
        table.get(1).add(estados.get(1));	// o
        table.get(1).add(estados.get(1));	// i
        table.get(1).add(estados.get(1));	// u

        table.get(1).add(estados.get(1));	// á
        table.get(1).add(estados.get(1));	// é
        table.get(1).add(estados.get(1));	// ó
        table.get(1).add(estados.get(1));	// í
        table.get(1).add(estados.get(1));	// ú

        table.get(1).add(estados.get(1));	// n
        table.get(1).add(estados.get(1));	// s
        table.get(1).add(estados.get(1));	// y
        table.get(1).add(estados.get(1));	// C - {n, s, y}

        table.get(1).add(estados.get(1));	// -

        //////////////////////////////////////// R2 = P1, P17
        table.get(2).add(estados.get(2));	// a
        table.get(2).add(estados.get(2));	// e
        table.get(2).add(estados.get(2));	// o
        table.get(2).add(estados.get(2));	// i
        table.get(2).add(estados.get(2));	// u

        table.get(2).add(estados.get(1));	// á
        table.get(2).add(estados.get(1));	// é
        table.get(2).add(estados.get(1));	// ó
        table.get(2).add(estados.get(1));	// í
        table.get(2).add(estados.get(1));	// ú

        table.get(2).add(estados.get(2));	// n
        table.get(2).add(estados.get(2));	// s
        table.get(2).add(estados.get(2));	// y
        table.get(2).add(estados.get(2));	// C - {n, s, y}

        table.get(2).add(estados.get(7));	// -

        //////////////////////////////////////// R3 = P3
        table.get(3).add(estados.get(2));	// a
        table.get(3).add(estados.get(2));	// e
        table.get(3).add(estados.get(2));	// o
        table.get(3).add(estados.get(2));	// i
        table.get(3).add(estados.get(2));	// u

        table.get(3).add(estados.get(4));	// á
        table.get(3).add(estados.get(4));	// é
        table.get(3).add(estados.get(4));	// ó
        table.get(3).add(estados.get(1));	// í
        table.get(3).add(estados.get(1));	// ú

        table.get(3).add(estados.get(2));	// n
        table.get(3).add(estados.get(2));	// s
        table.get(3).add(estados.get(2));	// y
        table.get(3).add(estados.get(2));	// C - {n, s, y}

        table.get(3).add(estados.get(7));	// -

        //////////////////////////////////////// R4 = P4, P7
        table.get(4).add(estados.get(1));	// a
        table.get(4).add(estados.get(1));	// e
        table.get(4).add(estados.get(1));	// o
        table.get(4).add(estados.get(5));	// i
        table.get(4).add(estados.get(5));	// u

        table.get(4).add(estados.get(1));	// á
        table.get(4).add(estados.get(1));	// é
        table.get(4).add(estados.get(1));	// ó
        table.get(4).add(estados.get(1));	// í
        table.get(4).add(estados.get(1));	// ú

        table.get(4).add(estados.get(6));	// n
        table.get(4).add(estados.get(6));	// s
        table.get(4).add(estados.get(6));	// y
        table.get(4).add(estados.get(6));	// C - {n, s, y}

        table.get(4).add(estados.get(8));	// -

        //////////////////////////////////////// R5 = P5, P8
        table.get(5).add(estados.get(1));	// a
        table.get(5).add(estados.get(1));	// e
        table.get(5).add(estados.get(1));	// o
        table.get(5).add(estados.get(1));	// i
        table.get(5).add(estados.get(1));	// u

        table.get(5).add(estados.get(1));	// á
        table.get(5).add(estados.get(1));	// é
        table.get(5).add(estados.get(1));	// ó
        table.get(5).add(estados.get(1));	// í
        table.get(5).add(estados.get(1));	// ú

        table.get(5).add(estados.get(6));	// n
        table.get(5).add(estados.get(6));	// s
        table.get(5).add(estados.get(6));	// y
        table.get(5).add(estados.get(6));	// C - {n, s, y}

        table.get(5).add(estados.get(8));	// -

        //////////////////////////////////////// R6 = P9
        table.get(6).add(estados.get(1));	// a
        table.get(6).add(estados.get(1));	// e
        table.get(6).add(estados.get(1));	// o
        table.get(6).add(estados.get(1));	// i
        table.get(6).add(estados.get(1));	// u

        table.get(6).add(estados.get(1));	// á
        table.get(6).add(estados.get(1));	// é
        table.get(6).add(estados.get(1));	// ó
        table.get(6).add(estados.get(1));	// í
        table.get(6).add(estados.get(1));	// ú

        table.get(6).add(estados.get(1));	// n
        table.get(6).add(estados.get(1));	// s
        table.get(6).add(estados.get(1));	// y
        table.get(6).add(estados.get(1));	// C - {n, s, y}

        table.get(6).add(estados.get(8));	// -

        //////////////////////////////////////// R7 = P6
        table.get(7).add(estados.get(14));	// a
        table.get(7).add(estados.get(14));	// e
        table.get(7).add(estados.get(14));	// o
        table.get(7).add(estados.get(14));	// i
        table.get(7).add(estados.get(14));	// u

        table.get(7).add(estados.get(1));	// á
        table.get(7).add(estados.get(1));	// é
        table.get(7).add(estados.get(1));	// ó
        table.get(7).add(estados.get(1));	// í
        table.get(7).add(estados.get(1));	// ú

        table.get(7).add(estados.get(14));	// n
        table.get(7).add(estados.get(14));	// s
        table.get(7).add(estados.get(7));	// y
        table.get(7).add(estados.get(7));	// C - {n, s, y}

        table.get(7).add(estados.get(1));	// -

        //////////////////////////////////////// R8 = P12
        table.get(8).add(estados.get(9));	// a
        table.get(8).add(estados.get(9));	// e
        table.get(8).add(estados.get(9));	// o
        table.get(8).add(estados.get(9));	// i
        table.get(8).add(estados.get(9));	// u

        table.get(8).add(estados.get(1));	// á
        table.get(8).add(estados.get(1));	// é
        table.get(8).add(estados.get(1));	// ó
        table.get(8).add(estados.get(1));	// í
        table.get(8).add(estados.get(1));	// ú

        table.get(8).add(estados.get(9));	// n
        table.get(8).add(estados.get(9));	// s
        table.get(8).add(estados.get(8));	// y
        table.get(8).add(estados.get(8));	// C - {n, s, y}

        table.get(8).add(estados.get(1));	// -

        //////////////////////////////////////// R9 = P13
        table.get(9).add(estados.get(9));	// a
        table.get(9).add(estados.get(9));	// e
        table.get(9).add(estados.get(9));	// o
        table.get(9).add(estados.get(9));	// i
        table.get(9).add(estados.get(9));	// u

        table.get(9).add(estados.get(1));	// á
        table.get(9).add(estados.get(1));	// é
        table.get(9).add(estados.get(1));	// ó
        table.get(9).add(estados.get(1));	// í
        table.get(9).add(estados.get(1));	// ú

        table.get(9).add(estados.get(10));	// n
        table.get(9).add(estados.get(10));	// s
        table.get(9).add(estados.get(11));	// y
        table.get(9).add(estados.get(11));	// C - {n, s, y}

        table.get(9).add(estados.get(1));	// -

        //////////////////////////////////////// R10 = p10
        table.get(10).add(estados.get(9));	// a
        table.get(10).add(estados.get(9));	// e
        table.get(10).add(estados.get(9));	// o
        table.get(10).add(estados.get(9));	// i
        table.get(10).add(estados.get(9));	// u

        table.get(10).add(estados.get(1));	// á
        table.get(10).add(estados.get(1));	// é
        table.get(10).add(estados.get(1));	// ó
        table.get(10).add(estados.get(1));	// í
        table.get(10).add(estados.get(1));	// ú

        table.get(10).add(estados.get(10));	// n
        table.get(10).add(estados.get(12));	// s
        table.get(10).add(estados.get(11));	// y
        table.get(10).add(estados.get(11));	// C - {n, s, y}

        table.get(10).add(estados.get(1));	// -

        //////////////////////////////////////// R11 = P11
        table.get(11).add(estados.get(9));	// a
        table.get(11).add(estados.get(9));	// e
        table.get(11).add(estados.get(9));	// o
        table.get(11).add(estados.get(9));	// i
        table.get(11).add(estados.get(9));	// u

        table.get(11).add(estados.get(1));	// á
        table.get(11).add(estados.get(1));	// é
        table.get(11).add(estados.get(1));	// ó
        table.get(11).add(estados.get(1));	// í
        table.get(11).add(estados.get(1));	// ú

        table.get(11).add(estados.get(9));	// n
        table.get(11).add(estados.get(13));	// s
        table.get(11).add(estados.get(8));	// y
        table.get(11).add(estados.get(8));	// C - {n, s, y}

        table.get(11).add(estados.get(1));	// -

        //////////////////////////////////////// R12 = P14
        table.get(12).add(estados.get(9));	// a
        table.get(12).add(estados.get(9));	// e
        table.get(12).add(estados.get(9));	// o
        table.get(12).add(estados.get(9));	// i
        table.get(12).add(estados.get(9));	// u

        table.get(12).add(estados.get(1));	// á
        table.get(12).add(estados.get(1));	// é
        table.get(12).add(estados.get(1));	// ó
        table.get(12).add(estados.get(1));	// í
        table.get(12).add(estados.get(1));	// ú

        table.get(12).add(estados.get(10));	// n
        table.get(12).add(estados.get(12));	// s
        table.get(12).add(estados.get(11));	// y
        table.get(12).add(estados.get(11));	// C - {n, s, y}

        table.get(12).add(estados.get(1));	// -

        //////////////////////////////////////// R13 = P15
        table.get(13).add(estados.get(9));	// a
        table.get(13).add(estados.get(9));	// e
        table.get(13).add(estados.get(9));	// o
        table.get(13).add(estados.get(9));	// i
        table.get(13).add(estados.get(9));	// u

        table.get(13).add(estados.get(1));	// á
        table.get(13).add(estados.get(1));	// é
        table.get(13).add(estados.get(1));	// ó
        table.get(13).add(estados.get(1));	// í
        table.get(13).add(estados.get(1));	// ú

        table.get(13).add(estados.get(10));	// n
        table.get(13).add(estados.get(10));	// s
        table.get(13).add(estados.get(11));	// y
        table.get(13).add(estados.get(11));	// C - {n, s, y}

        table.get(13).add(estados.get(1));	// -

        //////////////////////////////////////// R14 = P10
        table.get(14).add(estados.get(14));	// a
        table.get(14).add(estados.get(14));	// e
        table.get(14).add(estados.get(14));	// o
        table.get(14).add(estados.get(14));	// i
        table.get(14).add(estados.get(14));	// u

        table.get(14).add(estados.get(1));	// á
        table.get(14).add(estados.get(1));	// é
        table.get(14).add(estados.get(1));	// ó
        table.get(14).add(estados.get(1));	// í
        table.get(14).add(estados.get(1));	// ú

        table.get(14).add(estados.get(14));	// n
        table.get(14).add(estados.get(14));	// s
        table.get(14).add(estados.get(7));	// y
        table.get(14).add(estados.get(7));	// C - {n, s, y}

        table.get(14).add(estados.get(1));	// -
    }

    // Recibe una cadena a evaluar con las reglas establecidas
    void evaluarCadena(String cadena){
        String estadoActual, caminoActual;  // Indicadores para buscar el estado en done acabe la cadena
        int indexEstado = 0, indexCamino = 0;   // Coordenadas dentro de la tabla de transiciones
        String[] cadenaPorLetra;    // Cedan separada por letra

        estadoActual = estados.get(0).getId(); //El estado inicial va ser el primer estado dentro del conjunto de los estados

        cadenaPorLetra = cadena.split("(?!^)"); //Dividir cadena por letra y guardarlo en un arreglo
        String[][] transiciones = new String[estados.size()][alfabeto.size()];

        // Tabla de transiciones con puros ID en String
        for (int i = 0; i < transiciones.length; i++) {
            for (int j = 0; j < transiciones[0].length; j++) {
                transiciones[i][j] = table.get(i).get(j).getId();
            }
        }

        // Evaluar cada elemento de la cadena
        for (int i = 0; i < cadena.length(); i++) {
            if (!alfabeto.contains(cadenaPorLetra[i])) {  //Si una letra de al cadena no pertence al alfabeto, se rechaza la cadena
                System.out.printf("Elemento '%s' no pertenece al alfabeto\n", cadenaPorLetra[i]);
                estadoActual = "Invalid";
                break;
            }
            caminoActual = cadenaPorLetra[i]; //caminoActual toma el indice de la letra
            //Encontrar index del estadoActual
            for (int indexOnStatus = 0; indexOnStatus < estados.size(); indexOnStatus++)
                if (estadoActual.equals(estados.get(indexOnStatus).getId())) indexEstado = indexOnStatus;
            //Encontrar index del camino
            for (int indexOnPath = 0; indexOnPath < alfabeto.size(); indexOnPath++) {
                if (caminoActual.equals(alfabeto.get(indexOnPath))) indexCamino = indexOnPath;
            }
            //El nuevo estado es dado por los dos indice encontrados
            estadoActual = transiciones[indexEstado][indexCamino];
        }

        // Verificamos si el estadoActual termino siendo uno FINAL
        int flag = 0;
        for (int i = 0; i < estados.size(); i++) {
            if(estados.get(i).getEsFinal())
                if(estados.get(i).getId().equals(estadoActual))
                    flag = 1;
        }

        if(flag == 1){
            System.out.println("¡La palabra esta bien escrita!");
        }
        else
            System.out.println("Existe un error de acentuación.");

    }

    public String toString(){
        String result = "";
        for(int i = 0; i < table.size(); i++){
            for(int j = 0; j < table.get(i).size(); j++){
                result += table.get(i).get(j) + " ";
            }
            result += "\n";
        }
        return result;
    }
}

class Esdrujulas{
    private List<Estado> estados = new ArrayList<>();
    private List<String> alfabeto = new ArrayList<>();
    private List<List<Estado>> table = new ArrayList<>();

    public void setEstados(List<Estado> estados) { this.estados = estados; }
    public void setAlfabeto(List<String> alfabeto) { this.alfabeto = alfabeto; }

    public List<Estado> getEstados() { return estados; }
    public List<String> getAlfabeto() { return alfabeto; }
    public List<List<Estado>> getTransiciones() { return table; }

    // Cosntructor que toma el alfabeto y los estados que existan
    Esdrujulas(List<String> alfabeto, List<Estado> estados){
        setAlfabeto(alfabeto);
        setEstados(estados);
    }

    // Crear matriz de transicciones con datos del usuario
    void createTransitions(Scanner scanner, List<Estado> ListEstados){
        for(int i=0; i < estados.size(); i++) {
            table.add(new ArrayList<>());
        }

        String inputBuffer;
        int flag, indexOfEstado = 0;

        // Inicializar cada fila de la matriz
        for(int i=0; i < estados.size(); i++) {
            table.add(new ArrayList<>());
        }

        // Crear una copia de todos los estados
        List<String> ListEstadosID = new ArrayList<>();
        for (int i=0; i<ListEstados.size(); i++){
            ListEstadosID.add(ListEstados.get(i).getId());
        }

        // Agregando todas las transiciones...
        //////////////////////////////////////// R0 = P0
        table.get(0).add(estados.get(1));	// a
        table.get(0).add(estados.get(1));	// e
        table.get(0).add(estados.get(2));	// o
        table.get(0).add(estados.get(2));	// i
        table.get(0).add(estados.get(2));	// u

        table.get(0).add(estados.get(3));	// á
        table.get(0).add(estados.get(3));	// é
        table.get(0).add(estados.get(3));	// ó
        table.get(0).add(estados.get(4));	// í
        table.get(0).add(estados.get(4));	// ú

        table.get(0).add(estados.get(0));	// n
        table.get(0).add(estados.get(0));	// s
        table.get(0).add(estados.get(0));	// y
        table.get(0).add(estados.get(0));	// C - {n, s, y}

        table.get(0).add(estados.get(1));	// -

        //////////////////////////////////////// R1 = P1, P10
        table.get(1).add(estados.get(1));	// a
        table.get(1).add(estados.get(1));	// e
        table.get(1).add(estados.get(1));	// o
        table.get(1).add(estados.get(1));	// i
        table.get(1).add(estados.get(1));	// u

        table.get(1).add(estados.get(1));	// á
        table.get(1).add(estados.get(1));	// é
        table.get(1).add(estados.get(1));	// ó
        table.get(1).add(estados.get(1));	// í
        table.get(1).add(estados.get(1));	// ú

        table.get(1).add(estados.get(1));	// n
        table.get(1).add(estados.get(1));	// s
        table.get(1).add(estados.get(1));	// y
        table.get(1).add(estados.get(1));	// C - {n, s, y}

        table.get(1).add(estados.get(1));	// -

        //////////////////////////////////////// R2 = P2
        table.get(2).add(estados.get(1));	// a
        table.get(2).add(estados.get(1));	// e
        table.get(2).add(estados.get(1));	// o
        table.get(2).add(estados.get(1));	// i
        table.get(2).add(estados.get(1));	// u

        table.get(2).add(estados.get(3));	// á
        table.get(2).add(estados.get(3));	// é
        table.get(2).add(estados.get(3));	// ó
        table.get(2).add(estados.get(1));	// í
        table.get(2).add(estados.get(1));	// ú

        table.get(2).add(estados.get(1));	// n
        table.get(2).add(estados.get(1));	// s
        table.get(2).add(estados.get(1));	// y
        table.get(2).add(estados.get(1));	// C - {n, s, y}

        table.get(2).add(estados.get(1));	// -

        //////////////////////////////////////// R3 = P3, P6
        table.get(3).add(estados.get(1));	// a
        table.get(3).add(estados.get(1));	// e
        table.get(3).add(estados.get(1));	// o
        table.get(3).add(estados.get(4));	// i
        table.get(3).add(estados.get(4));	// u

        table.get(3).add(estados.get(1));	// á
        table.get(3).add(estados.get(1));	// é
        table.get(3).add(estados.get(1));	// ó
        table.get(3).add(estados.get(1));	// í
        table.get(3).add(estados.get(1));	// ú

        table.get(3).add(estados.get(5));	// n
        table.get(3).add(estados.get(5));	// s
        table.get(3).add(estados.get(5));	// y
        table.get(3).add(estados.get(5));	// C - {n, s, y}

        table.get(3).add(estados.get(6));	// -

        //////////////////////////////////////// R4 = P4, P5
        table.get(4).add(estados.get(1));	// a
        table.get(4).add(estados.get(1));	// e
        table.get(4).add(estados.get(1));	// o
        table.get(4).add(estados.get(1));	// i
        table.get(4).add(estados.get(1));	// u

        table.get(4).add(estados.get(1));	// á
        table.get(4).add(estados.get(1));	// é
        table.get(4).add(estados.get(1));	// ó
        table.get(4).add(estados.get(1));	// í
        table.get(4).add(estados.get(1));	// ú

        table.get(4).add(estados.get(5));	// n
        table.get(4).add(estados.get(5));	// s
        table.get(4).add(estados.get(5));	// y
        table.get(4).add(estados.get(5));	// C - {n, s, y}

        table.get(4).add(estados.get(6));	// -

        //////////////////////////////////////// R5 = P7
        table.get(5).add(estados.get(1));	// a
        table.get(5).add(estados.get(1));	// e
        table.get(5).add(estados.get(1));	// o
        table.get(5).add(estados.get(1));	// i
        table.get(5).add(estados.get(1));	// u

        table.get(5).add(estados.get(1));	// á
        table.get(5).add(estados.get(1));	// é
        table.get(5).add(estados.get(1));	// ó
        table.get(5).add(estados.get(1));	// í
        table.get(5).add(estados.get(1));	// ú

        table.get(5).add(estados.get(1));	// n
        table.get(5).add(estados.get(1));	// s
        table.get(5).add(estados.get(1));	// y
        table.get(5).add(estados.get(1));	// C - {n, s, y}

        table.get(5).add(estados.get(6));	// -

        //////////////////////////////////////// R6 = P8
        table.get(6).add(estados.get(6));	// a
        table.get(6).add(estados.get(6));	// e
        table.get(6).add(estados.get(6));	// o
        table.get(6).add(estados.get(6));	// i
        table.get(6).add(estados.get(6));	// u

        table.get(6).add(estados.get(1));	// á
        table.get(6).add(estados.get(1));	// é
        table.get(6).add(estados.get(1));	// ó
        table.get(6).add(estados.get(1));	// í
        table.get(6).add(estados.get(1));	// ú

        table.get(6).add(estados.get(6));	// n
        table.get(6).add(estados.get(6));	// s
        table.get(6).add(estados.get(6));	// y
        table.get(6).add(estados.get(6));	// C - {n, s, y}

        table.get(6).add(estados.get(7));	// -

        //////////////////////////////////////// R7 = P9
        table.get(7).add(estados.get(7));	// a
        table.get(7).add(estados.get(7));	// e
        table.get(7).add(estados.get(7));	// o
        table.get(7).add(estados.get(7));	// i
        table.get(7).add(estados.get(7));	// u

        table.get(7).add(estados.get(1));	// á
        table.get(7).add(estados.get(1));	// é
        table.get(7).add(estados.get(1));	// ó
        table.get(7).add(estados.get(1));	// í
        table.get(7).add(estados.get(1));	// ú

        table.get(7).add(estados.get(7));	// n
        table.get(7).add(estados.get(7));	// s
        table.get(7).add(estados.get(7));	// y
        table.get(7).add(estados.get(7));	// C - {n, s, y}

        table.get(7).add(estados.get(1));	// -
    }

    // Recibe una cadena a evaluar con las reglas establecidas
    void evaluarCadena(String cadena){
        String estadoActual, caminoActual;  // Indicadores para buscar el estado en done acabe la cadena
        int indexEstado = 0, indexCamino = 0;   // Coordenadas dentro de la tabla de transiciones
        String[] cadenaPorLetra;    // Cedan separada por letra

        estadoActual = estados.get(0).getId(); //El estado inicial va ser el primer estado dentro del conjunto de los estados

        cadenaPorLetra = cadena.split("(?!^)"); //Dividir cadena por letra y guardarlo en un arreglo
        String[][] transiciones = new String[estados.size()][alfabeto.size()];

        // Tabla de transiciones con puros ID en String
        for (int i = 0; i < transiciones.length; i++) {
            for (int j = 0; j < transiciones[0].length; j++) {
                transiciones[i][j] = table.get(i).get(j).getId();
            }
        }

        // Evaluar cada elemento de la cadena
        for (int i = 0; i < cadena.length(); i++) {
            if (!alfabeto.contains(cadenaPorLetra[i])) {  //Si una letra de al cadena no pertence al alfabeto, se rechaza la cadena
                System.out.printf("Elemento '%s' no pertenece al alfabeto\n", cadenaPorLetra[i]);
                estadoActual = "Invalid";
                break;
            }
            caminoActual = cadenaPorLetra[i]; //caminoActual toma el indice de la letra
            //Encontrar index del estadoActual
            for (int indexOnStatus = 0; indexOnStatus < estados.size(); indexOnStatus++)
                if (estadoActual.equals(estados.get(indexOnStatus).getId())) indexEstado = indexOnStatus;
            //Encontrar index del camino
            for (int indexOnPath = 0; indexOnPath < alfabeto.size(); indexOnPath++) {
                if (caminoActual.equals(alfabeto.get(indexOnPath))) indexCamino = indexOnPath;
            }
            //El nuevo estado es dado por los dos indice encontrados
            estadoActual = transiciones[indexEstado][indexCamino];
        }

        // Verificamos si el estadoActual termino siendo uno FINAL
        int flag = 0;
        for (int i = 0; i < estados.size(); i++) {
            if(estados.get(i).getEsFinal())
                if(estados.get(i).getId().equals(estadoActual))
                    flag = 1;
        }

        if(flag == 1){
            System.out.println("¡La palabra esta bien escrita!");
        }
        else
            System.out.println("Existe un error de acentuación.");
    }

    public String toString(){
        String result = "";
        for(int i = 0; i < table.size(); i++){
            for(int j = 0; j < table.get(i).size(); j++){
                result += table.get(i).get(j) + " ";
            }
            result += "\n";
        }
        return result;
    }
}

public class ProyectoFinal {
    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);  // Scanner para recibir datos del usuario
        String inputBuffer; //Recibe el dato de entrada sin limpiar
        List<String> alfabeto = new ArrayList<>(), estadosFinales;
        List<Estado> estadosActuales = new ArrayList<>();

        int numEstados, stopCondition, breakLoop = 0;
        String cadenaBuffer, opcionUsuario, cadenaLista_tmp, cadenaLista;  // Strings para almacenar y editar cadena
        String letter;

        do{
            // Inicializamos y vaciamos variables
            estadosActuales.clear();
            alfabeto.clear();
            numEstados = stopCondition = breakLoop = 0;
            cadenaBuffer = opcionUsuario = cadenaLista_tmp = cadenaLista = "";

            // Pedir cadena
            System.out.print("Ingresar palabra separada por guiones (-):  ");
            inputBuffer = inputScanner.nextLine();
            cadenaBuffer = inputBuffer;

            // Pedir opcion
            System.out.print("Escribe [A] si es Agudas, escribe [G] si es Grave o [E] si es Esdrujula; Otra letra para SALIR: ");
            inputBuffer = inputScanner.nextLine();
            opcionUsuario = inputBuffer;

            int numSilabas = cadenaBuffer.length() - cadenaBuffer.replace("-", "").length();    // Ver cuantas sílabas existen

            // EVALUAR PALABRAS AGUDAS
            if(opcionUsuario.equals("A")){
                // Agarramos la última sílaba
                for(int i=cadenaBuffer.length()-1; i > 0; i--){
                    letter = Character.toString(cadenaBuffer.charAt(i));
                    if(!letter.equals("-")){
                        cadenaLista_tmp += cadenaBuffer.charAt(i);
                    }
                    else
                        break;
                }
                cadenaLista = reverse(cadenaLista_tmp);
                cadenaLista = cadenaLista.replaceAll("[bcdfghjklmñpqrtvxz]", "C");  // Sustituimos el lista de consonantes por 'C'

                numEstados = 9; // Número de estados del AFD de Graves

                // Agregamos el alfabeto
                alfabeto.add("a"); alfabeto.add("e"); alfabeto.add("o");
                alfabeto.add("i"); alfabeto.add("u");
                alfabeto.add("á"); alfabeto.add("é"); alfabeto.add("ó");
                alfabeto.add("í"); alfabeto.add("ú");
                alfabeto.add("n"); alfabeto.add("s"); alfabeto.add("y"); alfabeto.add("C");
                alfabeto.add("-");

                // Inicializamos estados
                for(int i = 0; i<numEstados; i++)
                    estadosActuales.add(new Estado(""+i));

                // Indicamos que estados son finales
                estadosActuales.get(5).setEsFinal(true);
                estadosActuales.get(6).setEsFinal(true);
                estadosActuales.get(7).setEsFinal(true);
                estadosActuales.get(8).setEsFinal(true);

                // Creamos clase Agudas, creamos su tabla de transiciones y evaluamos
                Agudas A = new Agudas(alfabeto, estadosActuales);
                A.createTransitions(inputScanner, estadosActuales);
                A.evaluarCadena(cadenaLista);
            }

            // EVALUAR PALABRAS GRAVES
            else if(opcionUsuario.equals("G") && numSilabas > 0){
                // Agarramos la penúltima sílaba y la que le sigue
                for(int i=cadenaBuffer.length()-1; i >= 0; i--){
                    letter = Character.toString(cadenaBuffer.charAt(i));
                    if(letter.equals("-")){
                        stopCondition++;
                    }
                    if(stopCondition < 2)
                        cadenaLista_tmp += cadenaBuffer.charAt(i);
                    if(stopCondition == 2 && letter.equals("-"))
                        break;
                }

                // Sustituimos del lista de consonanstes, por 'C'
                cadenaLista = reverse(cadenaLista_tmp);
                cadenaLista = cadenaLista.replaceAll("[bcdfghjklmñpqrtvxz]", "C");

                numEstados = 15;    // Total de estados

                // Colocar alfabeto
                alfabeto.add("a"); alfabeto.add("e"); alfabeto.add("o");
                alfabeto.add("i"); alfabeto.add("u");
                alfabeto.add("á"); alfabeto.add("é"); alfabeto.add("ó");
                alfabeto.add("í"); alfabeto.add("ú");
                alfabeto.add("n"); alfabeto.add("s"); alfabeto.add("y"); alfabeto.add("C");
                alfabeto.add("-");

                // Inicializar estados
                for(int i = 0; i<numEstados; i++)
                    estadosActuales.add(new Estado(""+i));

                // Indicar estados finales
                estadosActuales.get(8).setEsFinal(true);
                estadosActuales.get(11).setEsFinal(true);
                estadosActuales.get(12).setEsFinal(true);
                estadosActuales.get(13).setEsFinal(true);
                estadosActuales.get(14).setEsFinal(true);

                // Crear clase Graves, creamos transiciones y evaluamos
                Graves G = new Graves(alfabeto, estadosActuales);
                G.createTransitions(inputScanner, estadosActuales);
                G.evaluarCadena(cadenaLista);

            }
            // EVALUAR PALABRAS ESDRÚJULAS
            else if(opcionUsuario.equals("E") && numSilabas >= 2){
                //  Agarramos las últimas 3 sílabas
                for(int i=cadenaBuffer.length()-1; i >= 0; i--){
                    letter = Character.toString(cadenaBuffer.charAt(i));
                    if(letter.equals("-")){
                        stopCondition++;
                    }
                    if(stopCondition < 3)
                        cadenaLista_tmp += cadenaBuffer.charAt(i);
                    if(stopCondition == 3 && letter.equals("-"))
                        break;
                }

                // Sustituimos als consonantes de la lista por un conjunto 'C'
                cadenaLista = reverse(cadenaLista_tmp);
                cadenaLista = cadenaLista.replaceAll("[bcdfghjklmñpqrtvxz]", "C");

                numEstados = 8; // Estados totales

                // Inicializamos el alfabeto
                alfabeto.add("a"); alfabeto.add("e"); alfabeto.add("o");
                alfabeto.add("i"); alfabeto.add("u");
                alfabeto.add("á"); alfabeto.add("é"); alfabeto.add("ó");
                alfabeto.add("í"); alfabeto.add("ú");
                alfabeto.add("n"); alfabeto.add("s"); alfabeto.add("y"); alfabeto.add("C");
                alfabeto.add("-");

                // Inicializamos los estaods
                for(int i = 0; i<numEstados; i++)
                    estadosActuales.add(new Estado(""+i));

                // Indicamos estados finales
                estadosActuales.get(7).setEsFinal(true);

                // Creamos clase Esdrujulas, creamos las transiciones y evaluamos
                Esdrujulas E = new Esdrujulas(alfabeto, estadosActuales);
                E.createTransitions(inputScanner, estadosActuales);
                E.evaluarCadena(cadenaLista);
            }
            // Si no fue ninguna de las 3 opciones, nos salimos
            else{
                System.out.println("Goodbye!");
                breakLoop = 1;
            }
            System.out.println();
        }while(breakLoop == 0);

        // Cerramos el scanner
        inputScanner.close();

    }

    // Función que invierte un String
    public static String reverse(String input){
        char[] in = input.toCharArray();
        int begin=0;
        int end=in.length-1;
        char temp;
        while(end>begin){
            temp = in[begin];
            in[begin]=in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        return new String(in);
    }
}
