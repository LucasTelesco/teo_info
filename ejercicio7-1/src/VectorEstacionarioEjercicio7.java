import utils.VectorOperation;

public class VectorEstacionarioEjercicio7 {

    private int nEstados = 3;
    final float EPSILON = 0.001f;
    final int MINIMO_EXPERIMENTOS = 10000;

    private float[][] ProbTransicionEstado = new float[][] {
            {0f, 1f/4f, 1f/4f},
            {1f/2f, 1f/2f, 1f/4f},
            {1f/2f, 1f/4f, 1f/2f},
    };

    public void CalcularVectorEstacionario(){

        float[] estado_actual = {1,0,0};
        float[] estado_anterior = {-1,0,0};
        int pasos = 0;

        while(!VectorOperation.ConvergeVector(estado_actual,estado_anterior,EPSILON) || pasos < MINIMO_EXPERIMENTOS){
            pasos ++;
            VectorOperation.CopiarVector(estado_actual,estado_anterior);
            float[] aux = VectorOperation.multiplica(ProbTransicionEstado,estado_actual);
            VectorOperation.CopiarVector(aux,estado_actual);
        }
        System.out.println("Resultado : ");
        System.out.println(estado_actual[0]);
        System.out.println(estado_actual[1]);
        System.out.println(estado_actual[2]);
        System.out.println(pasos);
    }

    public static void main(String[] args){
        VectorEstacionarioEjercicio7 vec = new VectorEstacionarioEjercicio7();
        vec.CalcularVectorEstacionario();
    }
}
