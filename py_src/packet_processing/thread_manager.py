from threading import Thread
from packet_processing import packet_consumer
from queue import Queue

def start_threads() -> None:
    """
    Starts producer and consumer threads.
    """

    # Create packet queue
    q = Queue()
    q.put_nowait('PRETZLER')

    # Create packet consumer thread
    pkt_consumer_t = Thread(target=packet_consumer.consume_packets, args=[q])

    # Start threads
    pkt_consumer_t.start()

    # Wait for threads to finish
    for i in range(1_000_000):
        continue

    pkt_consumer_t.join()
