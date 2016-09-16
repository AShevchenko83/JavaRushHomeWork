package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.*;

/**
 * Created by Admin on 27.08.16.
 */
public class AdvertisementManager
{
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos(){

        List<List<Advertisement>> combinaton = new ArrayList<>();
        List<Advertisement> refVideo = new ArrayList<>(storage.list());
        for (int i = 0; i < refVideo.size(); i++)
        {
            if (refVideo.get(i).getHits()<1||refVideo.get(i).getDuration()>timeSeconds) refVideo.remove(i);
        }

        if(refVideo.isEmpty())
            throw new NoVideoAvailableException();

        if(timeSeconds >= allVideoDuration(refVideo)) combinaton.add(refVideo);
        else {
            Set<Advertisement> set = new HashSet<>(refVideo);
            Set<Set<Advertisement>> setset= powerSet(set);
            for (Set<Advertisement> s:setset )
            {
                ArrayList<Advertisement> list= new ArrayList<>(s);
                combinaton.add(list);
            }
        }
        Collections.sort(combinaton, new Comparator<List<Advertisement>>()
        {
            @Override
            public int compare(List<Advertisement> o1, List<Advertisement> o2)
            {
                if(costsAllVideos(o1)!=costsAllVideos(o2)){
                    return costsAllVideos(o2)-costsAllVideos(o1);
                }
                else if(allVideoDuration(o1)!=allVideoDuration(o2)){
                    return allVideoDuration(o2)-allVideoDuration(o1);
                }
                else {
                    return o1.size()-o2.size();
                }
            }
        });
        ArrayList<Advertisement> videosToShow = new ArrayList<>(combinaton.get(0));
        for (int i = 0; i < videosToShow.size(); i++)
        {
            for (int j = 0; j < storage.list().size(); j++)
            {
                if(videosToShow.get(i).getName().equals(storage.list().get(j).getName())){
                    try
                    {
                        storage.list().get(j).revalidate();
                    }
                    catch (UnsupportedOperationException e)
                    {
                        ConsoleHelper.writeMessage("Eception in revalidate()");
                    }
                }
            }

        }
        Collections.sort(videosToShow, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                if(o1.getAmountPerOneDisplaying()!=o2.getAmountPerOneDisplaying()){
                    return (int)(o2.getAmountPerOneDisplaying()- o1.getAmountPerOneDisplaying());
                }
                else {
                    return (int)(o1.getAmountPerOneDisplaying()*1000/o1.getDuration()-
                            o2.getAmountPerOneDisplaying()*1000/o2.getDuration());
                }
            }
        });

        for (Advertisement ad: videosToShow             )
        {
            ConsoleHelper.writeMessage(ad.getName()+" is displaying... "+ad.getAmountPerOneDisplaying()+
                        ", "+ad.getAmountPerOneDisplaying()*1000/ad.getDuration());
        }
    }

    public int allVideoDuration (List<Advertisement> list){
        int dur =0;
        for (Advertisement ad: list)
        {
            dur+=ad.getDuration();
        }
        return dur;
    }

    public int costsAllVideos (List<Advertisement> list){
        int costs=0;
        for (Advertisement ad: list)
        {
            costs+= ad.getAmountPerOneDisplaying();
        }
        return costs;
    }


    public Set<Set<Advertisement>> powerSet (Set<Advertisement> originalSet){
        Set<Set<Advertisement>> sets = new HashSet<>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<Advertisement>());
            return sets;
        }
        List<Advertisement> list = new ArrayList<>(originalSet);
        Advertisement head = list.get(0);
        Set<Advertisement> rest = new HashSet<>(list.subList(1, list.size()));
        for (Set<Advertisement> set : powerSet(rest)) {
            Set<Advertisement> newSet = new HashSet<>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }
}
