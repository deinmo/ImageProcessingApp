package jan.org.ng.studentapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder>{
    private Context con;
    private ImageList [] myimagelist;

    public ImageAdapter(Context con, ImageList [] myimagelist) {
        this.con = con;
        this.myimagelist = myimagelist;
    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater Layoutinflater = LayoutInflater.from(parent.getContext());
        View imagelist = Layoutinflater.inflate(R.layout.listrow,parent,false);
        ViewHolder viewhold = new ViewHolder(imagelist);
        return viewhold;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageList img = myimagelist[position];
        holder.mytextview.setText(img.getMytext());
        holder.myimageview.setImageResource(img.getMyimage());
    }



    @Override
    public int getItemCount() {
        return myimagelist.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView myimageview;
        public TextView mytextview;

        public ViewHolder(View itemView) {
            super(itemView);

            this.myimageview = (ImageView) itemView.findViewById(R.id.myimageview);
            this.mytextview = (TextView) itemView.findViewById(R.id.mytextview);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context mycon = v.getContext();
                    int position = getAdapterPosition();
                    ImageList img = myimagelist[position];
                    Intent intent1 = new Intent(mycon, ImageProfile.class);
                    intent1.putExtra("Imageview", img.getMytext());
                    mycon.startActivity(intent1);

                }
            });

        }
    }

}
