package ui.wahyuapps.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.view.View;
import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.View.OnClickListener;

public class Adapter extends RecyclerView.Adapter <RecyclerView.ViewHolder>
{
	Context context;
	LayoutInflater inflater;
	List<Data> data;
	
	public Adapter (Context context, List<Data> data){
		this.context = context;
		inflater = LayoutInflater.from(context);
		this.data = data;
	}
	
	class MyHolder extends RecyclerView.ViewHolder {
		
		TextView title;
		TextView subtitle;
		ImageView image;
		
		public MyHolder (View view){
			super(view);
			
			title = view.findViewById(R.id.title);
			subtitle = view.findViewById(R.id.subtitle);
			image = view.findViewById(R.id.image);
			
			view.setOnClickListener(new
			OnClickListener(){
				@Override
				public void onClick(View v){
					// do anything woth onclick
				}
			});
		}
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		View view = inflater.inflate(R.layout.item_list, parent, false);
		MyHolder holder = new MyHolder(view);
		return holder;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
	{
		MyHolder myHolder = (MyHolder) holder;
		Data item = data.get(position);
		
		myHolder.title.setText(item.mTitle);
		myHolder.subtitle.setText(item.mSubtitle);
	}

	@Override
	public int getItemCount()
	{
		return data.size();
	}
	
}
