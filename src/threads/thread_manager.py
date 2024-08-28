from threading import Thread
from threads import packet_producer
from threads import packet_consumer
from queue import Queue

def start_threads() -> None:
    """
    Starts producer and consumer threads.
    """

    # Create packet queue
    q = Queue()
    q.put_nowait('DEADBEEF')
    q.put_nowait('PRETZLER')

    # Create packet producer thread
    pkt_producer_t = Thread(target=packet_producer.produce_packets, args=[q])

    # Create packet consumer thread
    pkt_consumer_t = Thread(target=packet_consumer.consume_packets, args=[q])

    # Start threads
    pkt_producer_t.start()
    pkt_consumer_t.start()

    # Wait for threads to finish
    for i in range(1_000_000):
        continue

    pkt_producer_t.join()
    pkt_consumer_t.join()
