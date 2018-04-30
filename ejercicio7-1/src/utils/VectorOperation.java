package utils;

public class VectorOperation {

    static public void InicializarVector(int[] vector, int valor)
    {
        for (int i = 0; i < vector.length; i++)
        {
            vector[i] = valor;
        }
    }

    static public float[] multiplica(float[][] matriz, float[] vector){
        float[] out = {0,0,0};

        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                out[i] += matriz[i][j] * vector[j];
            }
        }
        return out;
    }

    static public void InicializarVector(float[] vector, float valor)
    {
        for (int i = 0; i < vector.length; i++)
        {
            vector[i] = valor;
        }
    }

    static public void CopiarVector(float[] vector1, float[] vector2)
    {
        for (int i = 0; i < vector2.length; i++)
        {
            vector2[i] = vector1[i];
        }
    }

    static public boolean ConvergeVector(float[] probActual, float[] probAnterior, float epsilon)
    {
        for (int i = 0; i < probActual.length; i++)
        {
            if (!(Math.abs(probActual[i] - probAnterior[i]) < epsilon))
            {
                return false;
            }
        }

        return true;
    }
}
