package com.pixelplex.qtum.ui.fragment.SetYourTokenFragment;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.pixelplex.qtum.R;
import com.pixelplex.qtum.model.contract.ContractMethodParameter;

import java.util.List;


class ConstructorAdapter extends RecyclerView.Adapter<InputViewHolder> {

    private List<ContractMethodParameter> params;
    OnValidateParamsListener listener;

    public List<ContractMethodParameter> getParams(){
        return params;
    }

    public ConstructorAdapter(List<ContractMethodParameter> params, OnValidateParamsListener listener) {
        this.params = params;
        this.listener = listener;
    }

    @Override
    public InputViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new InputViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.lyt_constructor_input,parent, false), listener);
    }

    @Override
    public void onBindViewHolder(InputViewHolder holder, int position) {
        holder.bind(params.get(position),position == getItemCount()-1);
    }

    public boolean validateMethods(){
        for (ContractMethodParameter p : params){
            if(TextUtils.isEmpty(p.getValue())){
                return false;
            }
        }
        return true;
    }

    @Override
    public int getItemCount() {
        return params.size();
    }
}
