/**
 *
 * @author ADMIN
 */
package estructuras;
import clases.Viaje;

public class ruta_corta {    
    
    private final int limitedeVertices = 9999;  
    private final int valorGrande = 1<<30;  
    
    private lista_simple< lista_simple< NodoDjistra > > mi_listaAdyacencia = new lista_simple< lista_simple< NodoDjistra > >(); 
    private int distancia[ ] = new int[ limitedeVertices ];       
    private boolean vertices_yaVisitados[ ] = new boolean[ limitedeVertices ];  
    private cola_prioridad< NodoDjistra,NodoDjistra> colaDePrioridad = new cola_prioridad<NodoDjistra, NodoDjistra>();
    private int totalVeticesGrafo;                                    
    private int guardaLosCaminos[] = new int[ limitedeVertices ];         
    private boolean corriendoDjistra;
    
   ruta_corta (int totalVeticesGrafo){
     int index=0;
        this.totalVeticesGrafo = totalVeticesGrafo;

        while(index <= totalVeticesGrafo){
            mi_listaAdyacencia.add(new lista_simple<NodoDjistra>()) ;

          index++;
        }      
        corriendoDjistra = false;
    }
    

    class NodoDjistra implements Comparable<NodoDjistra>{
        int primero, segundo;
        NodoDjistra( int d , int p ){                     
            this.primero = d;
            this.segundo = p;
        }
        public int compareTo( NodoDjistra nodoAux){            
            if( segundo > nodoAux.segundo ) return 1;
            if( segundo == nodoAux.segundo ) return 0;
            return -1;
        }
    };

    private void constructorArreglos(){
        int indexar=0;
        while(indexar <= totalVeticesGrafo){
            distancia[ indexar ] = valorGrande;  
            vertices_yaVisitados[ indexar ] = false; 
            guardaLosCaminos[ indexar ] = -1;     
            indexar=indexar+1;
        }    
       

        
    }

 
    private void Actualizar( int vPresente , int vVecino , int peso ){
        if( distancia[ vPresente ] + peso < distancia[ vVecino ] ){
            distancia[ vVecino ] = distancia[ vPresente ] + peso;  
            guardaLosCaminos[ vVecino ] = vPresente;                        
            colaDePrioridad.encolar( new NodoDjistra( vVecino , distancia[ vVecino ] ),new NodoDjistra( vVecino , distancia[ vVecino ] ) );
        }
    }

    Viaje algoritmoDjistra( int inicial,Viaje viaje,int destinoIngresado ) throws Exception{
        constructorArreglos(); 
        colaDePrioridad.encolar( new NodoDjistra( inicial , 0 ),new NodoDjistra( inicial , 0 ) );
        distancia[ inicial ] = 0;     
        int verticePresente , verticeVecino , peso;
        while( !colaDePrioridad.estaVacia() ){                   
            verticePresente = colaDePrioridad.cabeza.getDato().primero;          
            colaDePrioridad.descolar();                          
            if( vertices_yaVisitados[ verticePresente ] ) continue; 
            vertices_yaVisitados[ verticePresente ] = true;         

            for( int i = 0 ; i < mi_listaAdyacencia.get( verticePresente ).size() ; ++i ){ 
                verticeVecino = mi_listaAdyacencia.get( verticePresente ).get( i ).primero;   
                peso = mi_listaAdyacencia.get( verticePresente ).get( i ).segundo;      
                if( !vertices_yaVisitados[ verticeVecino ] ){     
                    Actualizar( verticePresente , verticeVecino , peso ); 
                }
            }
        }
        System.out.println("Todas las Distancias Cortas desde nuestro vertice Inicial: "+inicial);
        
        for( int i = 1 ; i <= totalVeticesGrafo ; ++i ){
        System.out.println("Hacia el vertice destino: "+i+"  distancia mas corta al vertice : "+distancia[i]);
            if(destinoIngresado==i){viaje.setTiempoTotal(distancia[i]);} ////aca seteo el tiempo total del origen al destino
        }
        corriendoDjistra = true;
        return viaje;
    }
    
    void agregar_Arista( int origenObtenido , int destinoObtenido , int peso , boolean EsDirigido ) throws Exception{
        mi_listaAdyacencia.get( origenObtenido ).add( new NodoDjistra( destinoObtenido , peso ) );    //grafo diridigo
        if( !EsDirigido )
            mi_listaAdyacencia.get( destinoObtenido ).add( new NodoDjistra( origenObtenido , peso ) ); //no EsDirigido
    }
    
    lista_simple<Integer> pasoCaminos=new lista_simple<>();
    
    lista_simple<Integer> mostrarCaminoMasCorto(int destinoIngresado){
        if( !corriendoDjistra ){
            System.out.println("A ley ejecutar el Algoritma Djistra primero  ");
            return null;
        }

        System.out.println("\nCamino corto");
        System.out.printf("Ingrese vertice destino: ");     
        mostrarCamino( destinoIngresado);
        System.out.printf("\n"); 
        pasoCaminos.add(destinoIngresado);
        return this.pasoCaminos;
    }
    
    void mostrarCamino( int destino ){
        if( guardaLosCaminos[ destino ] != -1 ){  
            mostrarCamino( guardaLosCaminos[ destino ] );
            if(this.pasoCaminos.buscar(guardaLosCaminos[ destino ])==false){
            this.pasoCaminos.add( guardaLosCaminos[ destino ]);  }
        }
   
        System.out.printf("%d " , destino );       
    }

    public int GetTotalVetices() {
        return totalVeticesGrafo;
    }

    public void SetVertices(int numeroDeVertices) {
        totalVeticesGrafo = numeroDeVertices;
    }
}