package cis470.lecture24;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;


public class StepsHistoryActivity extends Activity{

    StepsDBHelper mStepsDBHelper;
    ListView mSensorListView;
    ListAdapter mListAdapter;
    ArrayList<DateStepsModel> mStepCountList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedometerlist_layout);
        mSensorListView = (ListView)findViewById(R.id.steps_list);

        getDataForList();

        mListAdapter = new ListAdapter(mStepCountList, this);
        mSensorListView.setAdapter(mListAdapter);

        Intent stepsIntent = new Intent(getApplicationContext(), StepsService.class);
        startService(stepsIntent);

    }

    public void getDataForList()
    {
        mStepsDBHelper = new StepsDBHelper(this);
        mStepCountList = mStepsDBHelper.readStepsEntries();
    }

}
