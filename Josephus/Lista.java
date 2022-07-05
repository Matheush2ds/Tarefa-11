public class Lista {
    
    Celula primeiro;
    Celula ultima;
    int totalDeElementos = 0;

    void AdicionarNoComeco(Object elemento){
        Celula nova = new Celula(this.primeiro, elemento);
        this.primeiro = nova;
        if(this.totalDeElementos == 0){
            this.ultima = this.primeiro;
        } 
        this.totalDeElementos++;
    }

    void adiciona(Object elemento){
        if(this.totalDeElementos == 0){
            this.AdicionarNoComeco(elemento);
        }else{ Celula nova = new Celula(elemento);
            this.ultima.setProxima(nova);
            this.ultima = nova;
            this.totalDeElementos++;
        }
    }

    boolean PosicaoOcupada(int pos){
        return((pos >= 0)&&(pos < this.totalDeElementos));
    }

    Celula PegaCelula(int pos){
        if(!this.PosicaoOcupada(pos)){
            throw new IllegalArgumentException("Posicao não existe");
        }else{ Celula atual = this.primeiro;
            for(int i = 0; i< pos; i++){
                atual = atual.getProxima();
            }
            return(atual);
        }
    }

    void adiciona(int pos, Object elemento){
        if(pos == 0){
            this.AdicionarNoComeco(elemento);
        }else if(pos == this.totalDeElementos){
            this.adiciona(elemento);
        }else{ Celula anterior = this.PegaCelula(-1);
            Celula nova = new Celula(anterior.getProxima(),elemento);
            anterior.setProxima(nova);
            this.totalDeElementos++;
        }
    }

    Object pega(int posicao){
        return(this.PegaCelula(posicao).getElemento());
    }

    void removeDoComeco(){
        if(!this.PosicaoOcupada(0)){
            throw new IllegalArgumentException("Posicao não existente");
        }else{ this.primeiro = this.primeiro.getProxima();
            this.totalDeElementos--;
            if(this.totalDeElementos == 0){
                this.ultima = null;
            }
        }
    }

    boolean Contem(Object elemento){
        Celula atual = this.primeiro;
        while(atual!=null){
            if(atual.getElemento().equals(elemento)){
                return (true);
            }
            atual = atual.getProxima();
        }
        return false;
    }

    int tamanho(){
        return(this.totalDeElementos);
    }
}