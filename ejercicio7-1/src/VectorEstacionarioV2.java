import utils.VectorOperation;
public class VectorEstacionarioV2 {


    private int nEstados = 3;
    final float EPSILON = 0.001f;
    final int MINIMO_EXPERIMENTOS = 10000;

    private float[][] ProbTransicionEstado = new float[][] {
            {0f, 1f/4f, 1f/4f},
            {1f/2f, 1f/2f, 1f/4f},
            {1f/2f, 1f/4f, 1f/2f},
    };

    private float[][] ProbTransicionEstadoAcum;

    /**
     * Inicializar vectores y matrices de probabilidad acumulada
     */
    public void InicializarMatrizProba()
    {
        ProbTransicionEstadoAcum = new float[nEstados][nEstados];

        for (int i = 0; i < nEstados; i++)
        {
            this.ProbTransicionEstadoAcum[i][0] = this.ProbTransicionEstado[i][0];
            for (int j = 1; j < nEstados; j++)
            {
                this.ProbTransicionEstadoAcum[i][j] = this.ProbTransicionEstadoAcum[i][j-1] + this.ProbTransicionEstado[i][j];
            }
        }
    }

    public void CalcularVectorEstacionario(){

        this.InicializarMatrizProba();
        int[] exitos = new int[nEstados];
        VectorOperation.InicializarVector(exitos, 0);
        float[] estado_actual = {0,0,0};
        float[] estado_anterior = {0,0,0};
        int pasos = 0;
        int estadoActual = 0;

        while(!VectorOperation.ConvergeVector(estado_actual,estado_anterior,EPSILON) || pasos < MINIMO_EXPERIMENTOS){
            pasos ++;
            estadoActual = VectorOperation.

            VectorOperation.CopiarVector(estado_actual,estado_anterior);


        }
        System.out.println("Resultado : ");
        System.out.println(estado_actual[0]);
        System.out.println(estado_actual[1]);
        System.out.println(estado_actual[2]);
        System.out.println(pasos);
    }

    private int ProximoEstadoDadoAnterior(int estadoAnterior)
    {
        float prob = (float) Math.random();
        int i = 0;
        while (i < nEstados)
        {
            if (prob < this.ProbTransicionEstadoAcum[estadoAnterior][i])
            {
                break;
            }

            i++;
        }

        return i;
    }


    public static void main(String[] args){
        VectorEstacionarioEjercicio7 vec = new VectorEstacionarioEjercicio7();
        vec.CalcularVectorEstacionario();
    }
}
