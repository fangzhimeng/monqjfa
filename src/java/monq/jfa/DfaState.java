package monq.jfa;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DfaState implements FaState<DfaState> {
  private Map<FaAction,FaSubinfo[]> subinfos = null;
  private CharTrans<DfaState> trans = EmptyCharTrans.instance();
  private FaAction action = null;
  
  public DfaState() {
    // nothing
  }
  public DfaState(FaAction a) {
    this.action = a;
  }
  @Override
  public boolean isImportant() {
    return getTrans().size()==0 || getAction()!=null || subinfos!=null;
  }

  @Override
  public DfaState[] getEps() {
    return null;
  }

  @Override
  public void setEps(DfaState[] newEps) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void addEps(DfaState[] others) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void addEps(DfaState other) {
    throw new UnsupportedOperationException();
  }

  @Override
  public CharTrans<DfaState> getTrans() {
    return trans;
  }

  @Override
  public void setTrans(CharTrans<DfaState> trans) {
    if (trans==null) {
      this.trans = EmptyCharTrans.instance();
    } else {
      this.trans = trans;
    }
  }

  @Override
  public FaAction getAction() {
    return action;
  }

  @Override
  public void clearAction() {
    action = null;
  }

  @Override
  public Iterator<DfaState> getChildIterator(monq.jfa.FaState.IterType iType) {
    throw new UnsupportedOperationException();    
  }

  @Override
  public DfaState follow(char ch) {
    CharTrans<DfaState> trans = getTrans();
    if( trans==null ) return null;
    DfaState state = trans.get(ch);
    return state;
  }

  @Override
  public void addUnassignedSub(FaSubinfo sfi) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void reassignSub(FaAction from, FaAction to) {
    throw new UnsupportedOperationException();    
  }

  @Override
  public <X extends FaState<X>> void mergeSubinfos(Set<X> nfaStates) {
    AbstractFaState.mergeSubinfosInto(subinfos, nfaStates);
  }

  @Override
  public Map<FaAction,FaSubinfo[]> getSubinfos() {
    return subinfos;
  }

}
