/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package DatabaseQuery;

public class boolPtr {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected boolPtr(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(boolPtr obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        DatabaseQueryJavaJNI.delete_boolPtr(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public boolPtr() {
    this(DatabaseQueryJavaJNI.new_boolPtr(), true);
  }

  public void assign(boolean value) {
    DatabaseQueryJavaJNI.boolPtr_assign(swigCPtr, this, value);
  }

  public boolean value() {
    return DatabaseQueryJavaJNI.boolPtr_value(swigCPtr, this);
  }

  public SWIGTYPE_p_bool cast() {
    long cPtr = DatabaseQueryJavaJNI.boolPtr_cast(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_bool(cPtr, false);
  }

  public static boolPtr frompointer(SWIGTYPE_p_bool t) {
    long cPtr = DatabaseQueryJavaJNI.boolPtr_frompointer(SWIGTYPE_p_bool.getCPtr(t));
    return (cPtr == 0) ? null : new boolPtr(cPtr, false);
  }

}
