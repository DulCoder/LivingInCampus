package com.fafu.zhengxianyou.livingincampus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.amap.api.services.busline.BusLineItem;
import com.fafu.zhengxianyou.livingincampus.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BusLineAdapter extends BaseAdapter {
	private Context mContext;
	private List<BusLineItem> busLineItems;
	private LayoutInflater layoutInflater;
	private String price;

	public BusLineAdapter(Context context, List<BusLineItem> busLineItems) {

		mContext = context;
		this.busLineItems = busLineItems;
		layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return busLineItems.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.busline_item, null);
			holder = new ViewHolder();
			holder.busName = (TextView) convertView.findViewById(R.id.bus_name);
			holder.fl_time = (TextView) convertView.findViewById(R.id.fl_time);
			holder.bus_price = (TextView) convertView.findViewById(R.id.bus_price);
			holder.busId = (TextView) convertView.findViewById(R.id.busId);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		BusLineItem busLineItem = busLineItems.get(position);

		holder.busName.setText("公 交 名  : "                       //获取公交名
				+ busLineItem.getBusLineName());

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");       //获取首末班车时间
		Date sDate,eDate;
		String start ,end;
		sDate = busLineItem.getFirstBusTime();
		eDate = busLineItem.getLastBusTime();
		if (sDate != null&&eDate != null) {
			start = sdf.format(sDate);
			end = sdf.format(eDate);
		}else {
			start = end ="未提供";
		}
		holder.fl_time.setText("首末班车: "+start+" --> "+end);

		price = String.valueOf(busLineItem.getBasicPrice());          //获取票价
		if (price.equals("0.0")){
			price = "未提供";
		}
        holder.bus_price.setText("单程票价: "+price);

		holder.busId.setText("公 交 ID  : "                           //获取公交ID
				+ busLineItem.getBusLineId());
		return convertView;
	}

	class ViewHolder {
		public TextView busName;
		public TextView fl_time;
		public TextView bus_price;
		public TextView busId;
	}

}
