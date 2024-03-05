# Xatranj

El Xatranj és un joc d'estratègia que serveix com a predecessor de l'escacs. I aquest projecte va de reacrear-lo amb Java.

### Classes Principals

1. **Fitxa.java**: Classe abstracta que representa una peça del Xatranj.
Defineix els atributs i mètodes comuns per a totes les peces del joc.

```java
public abstract class Fitxa {
    // ATRIBUTS
    protected String color;
    protected char visual;

    // CONSTRUCTOR
    public Fitxa() {
        super();
    }

    public Fitxa(String color, char visual) {
        this.color = color;
        this.visual = visual;
    }

    // MÈTODES
    public abstract boolean validarMoviment(int filaInicial, int columnaInicial, int filaDesti, int columnaDesti,
            String colorJugador, Fitxa[][] taulell);

    public String getColor() {
        return color;
    }

    public char getVisual() {
        return visual;
    }
}
```

2. **Taulell.java**: Representa el tauler de joc del Xatranj.
Conté mètodes per inicialitzar el tauler, validar moviments i gestionar les peces al tauler.

```java
public class Taulell {
    // ATRIBUTS
    private Fitxa[][] taulell = new Fitxa[8][8];

    // CONSTRUCTOR
    public Taulell() {
        inicialitzarTaulell();
    }

    // MÈTODES
    // Mètodes per inicialitzar el tauler, validar moviments i gestionar les peces.
}
```

3. **Xatranj.java**: Classe principal que conté el mètode `main` del joc.
Gestiona el flux del joc, els torns dels jugadors i la lògica del joc.

```java
public class Xatranj {
    // Mètode main i altres mètodes per gestionar el flux del joc.
}
```

### Classes de Peces

- Ruhk.java
- Faras.java
- Elefant.java
- Xa.java
- Ministre.java
- Baidaq.java

### Utilitats

- TaulellUtils.java: Classe que proporciona mètodes útils per operar amb el tauler i les peces del joc.
Creada per a treure pes i simplificar la classe Taulell.java

## Instruccions

1. Clona el repositori a la teva màquina local.
2. Obre el projecte al teu IDE preferit.
3. Executa la classe `Xatranj.java`.
4. Busca un amic amb qui jugar
5. Que guanyi el millor!