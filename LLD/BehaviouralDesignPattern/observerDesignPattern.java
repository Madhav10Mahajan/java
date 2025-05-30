/* it is used when we want to send to send some info/notification among all objects similar to subscribers of a yt channel
 * so instead of indivdually notifying each subscriber we can communicate to them together as a whole
 * this reduces coupling and is an efficient approach since it saves time
 */

/* given below is the traditional approach without following observer design pattern */
package BehaviouralDesignPattern;

import java.util.ArrayList;
import java.util.List;

// class YoutubeChannel {

//     public String channelName;
//     public String video;
//     public ArrayList<Subscriber> subscriberList = new ArrayList<>();

//     YoutubeChannel(String channelName) {
//         this.channelName = channelName;
//     }

//     public void addSubscriber(Subscriber subscriber) {
//         this.subscriberList.add(subscriber);
//     }

//     public void uploadVideo(String video) {
//         this.video = video;
//         notifySubscribers(video);
//     }

//     public void notifySubscribers(String video) {

//         for (Subscriber subscriber : this.subscriberList) {
//             System.out.println("hello " + subscriber.name + " a new video " + this.video + " has been uploaded");
//         }
//     }

// }

// class Subscriber {
//     public String name;
//     public String id;
//     public String email;
//     public ArrayList<YoutubeChannel> channels = new ArrayList<>();

//     Subscriber(String name, String id, String email) {
//         this.id = id;
//         this.email = email;
//         this.name = name;
//     }

//     public void addChannel(YoutubeChannel channel) {
//         this.channels.add(channel);
//     }

//     public void showList() {
//         for (YoutubeChannel channel : this.channels) {
//             System.out.println(this.name + " has subscribed to " + channel.channelName);
//         }
//     }
// }

interface YoutubeChannel {

    public void uploadVideo(String video);

    public void addSubscriber(String name);

    public void removeSubscriber(String name);

    public void notifySubscribers(String video);
}
// using observer design pattern
/* reduces decoupling, increases scalability and flexibility
 * readablke, maintainable and more modular code
 */
class YoutubeChannelImp implements YoutubeChannel {

    public List<String> subscribers = new ArrayList<>();
    public List<String> videos = new ArrayList<>();

    @Override
    public void addSubscriber(String name) {
        this.subscribers.add(name);
    }

    @Override
    public void removeSubscriber(String name) {
        this.subscribers.remove(name);
    }

    @Override
    public void uploadVideo(String video) {
        this.videos.add(video);
    }

    @Override
    public void notifySubscribers(String video) {

        for (String subscriber : this.subscribers) {
            System.out.println("Hey " + subscriber + " a new video  " + video + " has been uploaed");
        }
    }

}

public class observerDesignPattern {

    public static void main(String[] args) {
        // YoutubeChannel channel1 = new YoutubeChannel("Madhav Reacts");
        // Subscriber madhav = new Subscriber("madhav", "123",
        // "madhav.mhjn01@gmail.com");
        // madhav.addChannel(channel1);
        // channel1.addSubscriber(madhav);
        // channel1.uploadVideo("meme compilation");
        // madhav.showList();
        YoutubeChannelImp channel=new YoutubeChannelImp();
        channel.addSubscriber("alice");
        channel.addSubscriber("bob");
        channel.uploadVideo("meme compilation");
        channel.notifySubscribers("meme compliation");
    }
}