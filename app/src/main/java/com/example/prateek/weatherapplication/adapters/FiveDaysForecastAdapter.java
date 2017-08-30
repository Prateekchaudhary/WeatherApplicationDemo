package com.example.prateek.weatherapplication.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.prateek.weatherapplication.R;
import com.example.prateek.weatherapplication.activities.FiveDayForeCastActivity;
import com.example.prateek.weatherapplication.models.FiveDaysForecastModel;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Prateek on 24/08/17.
 */

public class FiveDaysForecastAdapter extends RecyclerView.Adapter<FiveDaysForecastAdapter.DataObjectViewHolder> {


    private Context mContext;
    private ArrayList<FiveDaysForecastModel> fiveDaysForecastArrayList;
    private String mCountDays;

    /*
        DateFormat df = DateFormat.getDateTimeInstance();
    */
    DateFormat df = DateFormat.getDateInstance();

    public FiveDaysForecastAdapter(FiveDayForeCastActivity fiveDayForeCastActivity, ArrayList<FiveDaysForecastModel> fiveDaysForecastArrayList, String mCountDays) {

        this.mContext = fiveDayForeCastActivity;
        this.fiveDaysForecastArrayList = fiveDaysForecastArrayList;
        this.mCountDays = mCountDays;
    }

    @Override
    public DataObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_fivedaysforecast, null);
        DataObjectViewHolder dataObjectViewHolder = new DataObjectViewHolder(view);
        return dataObjectViewHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectViewHolder holder, int position) {

        try {
            FiveDaysForecastModel fiveDaysForecastModel = fiveDaysForecastArrayList.get(position);


            holder.mTextViewCloud.setText(fiveDaysForecastModel.getDescription());
            holder.mTextViewMaxTemp.setText(String.format("%.0f", (Double.parseDouble(fiveDaysForecastModel.getMin()) - 273.16f)) + "\u00B0 C");
            holder.mTextViewMinTemp.setText(String.format("%.0f", (Double.parseDouble(fiveDaysForecastModel.getMax()) - 273.16f)) + "\u00B0 C");
            holder.mTextViewHumidity.setText(fiveDaysForecastModel.getHumidity() + " %");
            holder.mTextViewPressue.setText(fiveDaysForecastModel.getPressure() + " hPa");
            holder.mTextViewSnow.setText(fiveDaysForecastModel.getSnow() + " %");
            holder.mTextViewSpeed.setText(fiveDaysForecastModel.getSpeed() + " km/h");
            holder.mTextViewTempAfternoon.setText(String.format("%.0f", Double.parseDouble(fiveDaysForecastModel.getDay()) - 273.16f) + "\u00B0 C");
            holder.mTextViewTempMorn.setText(String.format("%.0f", Double.parseDouble(fiveDaysForecastModel.getMorn()) - 273.16f) + "\u00B0 C");
            holder.mTextViewTempEven.setText(String.format("%.0f", Double.parseDouble(fiveDaysForecastModel.getEve()) - 273.16f) + "\u00B0 C");
            holder.mTextViewTempNight.setText(String.format("%.0f", Double.parseDouble(fiveDaysForecastModel.getNight()) - 273.16f) + "\u00B0 C");
            holder.mTextViewWind.setText(fiveDaysForecastModel.getDescription() + ", " + fiveDaysForecastModel.getSpeed() + " km/h");

            String updatedOn = df.format(new Date(Long.parseLong(fiveDaysForecastModel.getDt()) * 1000));
            holder.mTextViewWeekDayName.setText(updatedOn);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return (null != fiveDaysForecastArrayList ? fiveDaysForecastArrayList.size() : 0);
    }

    public class DataObjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTextViewMaxTemp;
        private TextView mTextViewMinTemp;
        private TextView mTextViewWeekDayName;
        private TextView mTextViewSpeed;
        private TextView mTextViewHumidity;
        private TextView mTextViewSnow;
        private TextView mTextViewPressue;
        private TextView mTextViewCloud;
        private TextView mTextViewTempMorn;
        private TextView mTextViewTempAfternoon;
        private TextView mTextViewTempEven;
        private TextView mTextViewTempNight;
        private TextView mTextViewWind;

        public DataObjectViewHolder(View itemView) {
            super(itemView);


            mTextViewMaxTemp = (TextView) itemView.findViewById(R.id.mTextViewMaxTemp);
            mTextViewMinTemp = (TextView) itemView.findViewById(R.id.mTextViewMinTemp);
            mTextViewWeekDayName = (TextView) itemView.findViewById(R.id.mTextViewWeekDayName);
            mTextViewSpeed = (TextView) itemView.findViewById(R.id.mTextViewSpeed);
            mTextViewHumidity = (TextView) itemView.findViewById(R.id.mTextViewHumidity);
            mTextViewSnow = (TextView) itemView.findViewById(R.id.mTextViewSnow);
            mTextViewPressue = (TextView) itemView.findViewById(R.id.mTextViewPressue);
            mTextViewCloud = (TextView) itemView.findViewById(R.id.mTextViewCloud);
            mTextViewTempMorn = (TextView) itemView.findViewById(R.id.mTextViewTempMorn);
            mTextViewTempAfternoon = (TextView) itemView.findViewById(R.id.mTextViewTempAfterNoon);
            mTextViewTempEven = (TextView) itemView.findViewById(R.id.mTextViewTempEven);
            mTextViewTempNight = (TextView) itemView.findViewById(R.id.mTextViewTempNight);
            mTextViewWind = (TextView) itemView.findViewById(R.id.mTextViewWind);

        }

        @Override
        public void onClick(View view) {

        }
    }
}
