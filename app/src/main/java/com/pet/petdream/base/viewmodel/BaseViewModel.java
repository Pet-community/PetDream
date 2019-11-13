package com.pet.petdream.base.viewmodel;

import android.util.Log;

import androidx.databinding.ViewDataBinding;

import com.pet.petdream.base.model.BaseModel;
import com.pet.petdream.base.model.OnModelListener;
import com.pet.petdream.base.view.IBaseView;

import java.lang.ref.SoftReference;

/**
 * @author wuyang
 * @create 2019/11/7
 * @Describe V
 */
public abstract class BaseViewModel <V extends IBaseView,M extends BaseModel> implements IBaseViewModel<V>{
protected SoftReference<V> softReference;
    @Override
    public void attachView(V view) {
        softReference=new SoftReference<>(view);
        Log.i("BUG测试","softReference对象创建完毕");

    }

    @Override
    public void detachView() {
        V view=getview();
        view=null;
        softReference.clear();
        softReference=null;
        Log.i("BUG测试","softReference对象置空");
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
