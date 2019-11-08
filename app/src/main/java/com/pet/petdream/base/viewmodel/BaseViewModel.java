package com.pet.petdream.base.viewmodel;

import androidx.databinding.ViewDataBinding;

import com.pet.petdream.base.model.BaseModel;
import com.pet.petdream.base.view.IBaseView;

import java.lang.ref.SoftReference;

/**
 * @author wuyang
 * @create 2019/11/7
 * @Describe
 */
public abstract class BaseViewModel <V extends IBaseView,M extends BaseModel> implements IBaseViewModel<V>{
protected SoftReference<V> softReference;
    @Override
    public void attachView(V view) {
        softReference=new SoftReference<>(view);

    }

    @Override
    public void detachView() {
        V view=getview();
        view=null;
        softReference.clear();
        softReference=null;
    }
    protected  V getview(){
        return softReference.get();
    }
    protected M model = createModel();

    /**
     * 创建Model
     * @return
     */
    protected abstract M createModel();
    /**
     * 是否已经解除关联
     * @return
     */
    protected boolean isAttachView(){
        return softReference==null||softReference.get() != null;
    }

}
