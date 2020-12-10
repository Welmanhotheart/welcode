package bytecode.classFileInterpretation.formats;

import bytecode.classFileInterpretation.constants.Usize;

public class Magic extends SingleFormat {
   private final int size = Usize.U4;

   private String desc;

   public  int getSize() {
        return size;
   }

   public void setDesc(String desc) {
        this.desc = desc;
   }
}
