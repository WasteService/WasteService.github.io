/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.29
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package cloog;

public class clooginfos {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected clooginfos(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(clooginfos obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public void delete() {
    if(swigCPtr != 0 && swigCMemOwn) {
      swigCMemOwn = false;
      CLooGJNI.delete_clooginfos(swigCPtr);
    }
    swigCPtr = 0;
  }

  public SWIGTYPE_p_Value getStride() {
    long cPtr = CLooGJNI.clooginfos_stride_get(swigCPtr);
    return (cPtr == 0) ? null : new SWIGTYPE_p_Value(cPtr, false);
  }

  public int getLanguage() {
    return CLooGJNI.clooginfos_language_get(swigCPtr);
  }

  public int getNb_scattdims() {
    return CLooGJNI.clooginfos_nb_scattdims_get(swigCPtr);
  }

  public SWIGTYPE_p_int getScaldims() {
    long cPtr = CLooGJNI.clooginfos_scaldims_get(swigCPtr);
    return (cPtr == 0) ? null : new SWIGTYPE_p_int(cPtr, false);
  }

  public cloognames getNames() {
    long cPtr = CLooGJNI.clooginfos_names_get(swigCPtr);
    return (cPtr == 0) ? null : new cloognames(cPtr, false);
  }

  public cloogoptions getOptions() {
    long cPtr = CLooGJNI.clooginfos_options_get(swigCPtr);
    return (cPtr == 0) ? null : new cloogoptions(cPtr, false);
  }

  public clooginfos() {
    this(CLooGJNI.new_clooginfos(), true);
  }

}