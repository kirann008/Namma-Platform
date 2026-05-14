package com.example.nammaplatform

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TrainAdapter(
    private val trainList: List<TrainBoard>
) : RecyclerView.Adapter<TrainAdapter.TrainViewHolder>() {

    class TrainViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val trainName: TextView =
            itemView.findViewById(R.id.trainName)

        val kannadaName: TextView =
            itemView.findViewById(R.id.trainKannada)

        val platformNumber: TextView =
            itemView.findViewById(R.id.platformNumber)

        val trainTime: TextView =
            itemView.findViewById(R.id.trainTime)

        val announceButton: Button =
            itemView.findViewById(R.id.announceButton)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrainViewHolder {

        val view =
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_train_card,
                    parent,
                    false
                )

        return TrainViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: TrainViewHolder,
        position: Int
    ) {

        val train =
            trainList[position]

        // Set Data

        holder.trainName.text =
            train.trainName

        holder.kannadaName.text =
            train.kannadaName

        holder.platformNumber.text =
            "Platform : ${train.platform}"

        holder.trainTime.text =
            train.time

        // Announcement Button

        holder.announceButton.setOnClickListener {

            val context =
                holder.itemView.context

            val intent =
                Intent(
                    context,
                    AudioAssistantActivity::class.java
                )

            intent.putExtra(
                "announcement",
                train.announcement
            )

            intent.putExtra(
                "train_name",
                train.kannadaName
            )

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {

        return trainList.size
    }
}