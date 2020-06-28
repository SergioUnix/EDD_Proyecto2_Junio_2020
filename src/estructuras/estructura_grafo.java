/**
 *
 * @author Sergio Ariel Ramirez Castro
 */
package estructuras;
import clases.transicion;

public class estructura_grafo {
        estructura_grafo next1;
        estructura_grafo next2;

        int peso;
        int tamanio=0;
        String origen;
        String destino;    
        lista_simple<transicion> transiciones = new lista_simple<transicion>();
        
        ///Atributos para la matrix adyacente
        public int totalVertices_;  ///este es el tamanio de lista tambien
        public int totalAristas_;
        public int numeroAristas;
        public int matriz_rutas[][];
        public lista_simple<String> nameRutas=new lista_simple<>();
        public  int distance[];
        
        
        

        public estructura_grafo()
        {
            this.origen = "";
            this.destino = "";
            this.peso = 0;
            this.next1 = null;
            this.next2 = null;
            //inizializando para la matriz_rutas
            numeroAristas=0;
            totalVertices_=0;
            totalAristas_=0;
            matriz_rutas=null;
        }
        
        ////metodo hace que mi matriz sea del tamanio cuando quiera...
        public void inicializandoMatriz(int cantidadVertices){
            this.totalVertices_=cantidadVertices;    
            matriz_rutas=new int[this.tamanio+20][this.tamanio+20];   
            this.distance = new int[this.tamanio+20];
        }
        
        
        
        public String getOrigen()
        {
            return this.origen;
        }
                public void setOrigen(String i)
        {
            this.origen = i;
        }
          public void setDestino(String b)
        {
            this.destino = b;
        }
        public String getDestino()
        {
            return this.destino;
        }
                public int getPeso()
        {
           return  this.peso;
        }
                public void setPeso(int s)
        {
            this.peso = s;
        }
                public void setNext1(estructura_grafo next1)
        {
            this.next1 = next1;
        }
        public estructura_grafo getNext1()
       {
            return this.next1;
       }

        public void setNext2(estructura_grafo next2)
        {
            this.next2 = next2;
        }
        public estructura_grafo getNext2()
        {
          return this.next2;
        }
        public void addTransicion(transicion b)
        {
            this.transiciones.add(b);
        }
        
        public int getSize(){return this.tamanio;}
        
        
        
        public void agregoRuta(String origenC, String destinoC,String pesoC){
            estructura_grafo nuevo=new estructura_grafo();
            nuevo.setOrigen(origenC);
            nuevo.setDestino(pesoC);
            nuevo.addTransicion(new transicion(destinoC,pesoC));
            
            estructura_grafo aux=this.next1;
            
          //  boolean verifco=false;
            if(origen.equals(origenC)){              
               transiciones.add(new transicion(destinoC,pesoC));
               this.totalAristas_++;
          
            }else if(origen.equals("")){
            this.origen=origenC;   
            this.addTransicion(new transicion (destinoC,pesoC));
            tamanio++;      nameRutas.add(this.origen);  this.totalAristas_++;
            }else{
              //System.out.println("---  entro al else  "+origenC);
                while(aux!=null){
                // System.out.println("---  entro al while"+origenC);
                 
                 if(aux.origen.equals(origenC)){
                     aux.addTransicion(new transicion(destinoC,pesoC));  this.totalAristas_++;                    
                 break;  
                 }
                 if(aux.getNext1()==null){aux.setNext1(nuevo);tamanio++; nameRutas.add(nuevo.origen); this.totalAristas_++;break; }
                aux=aux.getNext1();
                }
                if(aux==null){this.setNext1(nuevo); tamanio++;nameRutas.add(nuevo.origen);  this.totalAristas_++;}
              
            }
           
            
        }
        
         public void imprimir() throws Exception{
            estructura_grafo aux=this.next1;
            System.out.println("-----------"+origen);
            for(int i=0;i<transiciones.size();i++){
            System.out.println("           "+transiciones.get(i).getNombre()+"    "+transiciones.get(i).getDireccion()); 
            }
            while(aux!=null){                
            System.out.println(" ----------"+aux.getOrigen());
            for(int i=0;i<aux.transiciones.size();i++){
            System.out.println("           "+aux.transiciones.get(i).getNombre()+"    "+aux.transiciones.get(i).getDireccion()); 
            }           
            aux=aux.getNext1();
            }
         }
         public String cadenaGrafico() throws Exception{
            String res="graph grafoRutas { \n" +"layout=\"circo\";\n" +"size = \"30\"\n" +"node[shape = doublecircle margin = 0 , color=mistyrose2, fontcolor = white fontsize = 15 width = 0.5 style = filled, fillcolor = black];\n";
            String direccion="";
         
            estructura_grafo aux=this.next1;
            System.out.println("-----------"+origen);
            for(int i=0;i<transiciones.size();i++){
            direccion=direccion+"\""+(nameRutas.getPosicion(origen)+1)+"."+origen+"\"-- \""+(nameRutas.getPosicion(transiciones.get(i).getNombre())+1)+"."+transiciones.get(i).getNombre()+"\"[dir=\"forward\", color=crimson,label = \""+transiciones.get(i).getDireccion()+"\", fontcolor=darkolivegreen4]; \n";   
            }
      
            while(aux!=null){
            for(int i=0;i<aux.transiciones.size();i++){
            direccion=direccion+"\""+(nameRutas.getPosicion(aux.getOrigen())+1)+"."+aux.getOrigen()+"\"-- \""+(nameRutas.getPosicion(aux.transiciones.get(i).getNombre())+1)+"."+aux.transiciones.get(i).getNombre()+"\"[dir=\"forward\", color=crimson,label = \""+aux.transiciones.get(i).getDireccion()+"\", fontcolor=darkolivegreen4]; \n";   
            }           
            aux=aux.getNext1(); 
            }
           res=res+direccion;
            return res+"label=\"{Rutas de Llega Rapidito}\";\n }";
         }
         
        public String getRuta(int index){
        int comodin=1;
        if(index==0){
            //  System.out.println("tamanio "+this.tamanio+" origen"+this.origen+"  index  "+index);
            return this.origen;          
        }else{
            estructura_grafo aux=this.getNext1();
            while(comodin<this.tamanio){
                
          //  System.out.println("tamanio "+this.tamanio+" origen"+aux.origen+"  index "+index);
                 
           if(comodin==index){  return aux.origen;}      
           aux=aux.getNext1();
           comodin++;  
            }
        }
        return "";
        }
        
        
        
        
        
        
         
        //////////////////////proceso de agregar a mi matriz 
        
        public int obtenerPeso(String nombreNota,String transi) throws Exception {
            int result=0;
        int comodin=1;
        if(nombreNota.equals(origen)){
              for(int k=0;k<transiciones.size();k++){
                  if(transi.equals(transiciones.get(k).destino)){ result=Integer.parseInt(transiciones.get(k).direccion);  };    }
            return result;          
        }else{
            estructura_grafo aux=this.getNext1();
            while(comodin<this.tamanio){
                        if(nombreNota.equals(aux.origen)){
                        for(int k=0;k<aux.transiciones.size();k++){
                        if(transi.equals(aux.transiciones.get(k).destino)){ result=Integer.parseInt(aux.transiciones.get(k).direccion);  };    }     
                        }
           aux=aux.getNext1();
           comodin++;  
            }
        }
        return result;
        
        }
        
        
        public void  llenoMatriz() throws Exception{
        //inicializo la matriz
        this.inicializandoMatriz(tamanio);
        int i,j;
        
        for(i=1;i<=tamanio;i++){
          for(j=1;j<=tamanio;j++)
          {
           matriz_rutas[i][j]=obtenerPeso(nameRutas.get(i-1),nameRutas.get(j-1));
           if(matriz_rutas[i][j]==0)
           matriz_rutas[i][j]=999;
          }
       }
    //this.imprimirMatriz();
    //this.caminoMasCorto("Madrid");
    this.metCorto("Cadiz","Coruna");
        
        }
        
        
        public void imprimirMatriz(){
        int i,j;
        for(i=0;i<=tamanio;i++){
          for(j=0;j<=tamanio;j++)
          {
           System.out.print(matriz_rutas[i][j]+"  "); 
          }
           System.out.println("\n");
  }
        
        }
        
        
        
        
        
  public void calc(int n,int s)
 {
  int flag[] = new int[n+1];
  int i,minpos=1,k,c,minimum;
  
  for(i=1;i<=n;i++)
  {  
      flag[i]=0; 
      this.distance[i]=this.matriz_rutas[s][i]; 
  }
  c=2;
  while(c<=n)
  {
   minimum=99;
   for(k=1;k<=n;k++)
   { 
          if(this.distance[k]<minimum && flag[k]!=1)
       {
        minimum=this.distance[i];
        minpos=k;
       }
      } 
            flag[minpos]=1;
      c++;
      for(k=1;k<=n;k++){
       if(this.distance[minpos]+this.matriz_rutas[minpos][k] <  this.distance[k] && flag[k]!=1 )
       this.distance[k]=this.distance[minpos]+this.matriz_rutas[minpos][k];
   }   
  } 
  
 }       
     
   
 public void caminoMasCorto(String Destino) throws Exception{
     int valordeOrigen=nameRutas.getPosicion(Destino)+1;
     int i,j;  
     
     for(int t=0;t<nameRutas.size();t++){
      System.out.println("Valor de los vertices "+ nameRutas.get(t)+"  posicion arreglo "+(t)+" valor de Origen obtenido  " +valordeOrigen+"\n");
     }
     
 this.calc(tamanio,valordeOrigen);
  System.out.println("The Shortest Path from Source \t"+valordeOrigen+"\t to all other vertices are : \n");
        for(i=1;i<=tamanio;i++)
          if(i!=valordeOrigen)
  System.out.println("source :"+valordeOrigen+"\t destination :"+i+"\t MinCost is :"+this.distance[i]+"\t");
        
 }       
        
        
  ////////////////////////////////////////////Se calcula el camino mas corto de un nodo origen hacia un nodo destino      
  public void metCorto(String origenIngresado,String destinoIngresado) throws Exception {
        int E , origen, destino , peso , inicial, V;
       //numero total de Vertices
        V = this.tamanio;
       //total de aristas
        E = this.totalAristas_++;
        ruta_corta dijkstraAlgorithm = new ruta_corta(V);
        
        
                

            estructura_grafo aux=this.next1;
            for(int i=0;i<transiciones.size();i++){
                dijkstraAlgorithm.addEdge(nameRutas.getPosicion(this.origen)+1,    nameRutas.getPosicion(transiciones.get(i).getNombre())+1, Integer.parseInt(transiciones.get(i).getDireccion())   , true);
            }
            while(aux!=null){
            for(int i=0;i<aux.transiciones.size();i++){
           dijkstraAlgorithm.addEdge(nameRutas.getPosicion(aux.origen)+1,    nameRutas.getPosicion(aux.transiciones.get(i).getNombre())+1, Integer.parseInt(aux.transiciones.get(i).getDireccion())   , true);  
            }           
            aux=aux.getNext1(); 
            }

 
        
        System.out.print("Ingrese el vertice inicial: ");
        inicial =nameRutas.getPosicion(origenIngresado)+1;
        dijkstraAlgorithm.dijkstra(inicial);
        destino =nameRutas.getPosicion(destinoIngresado)+1;
        dijkstraAlgorithm.printShortestPath(destino);
    }       
 
 
 
 

}