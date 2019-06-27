import cv2

capture = cv2.VideoCapture(0) #카메라 영상 밭아오기

#카메라 해상도
capture.set(cv2.CAP_PROP_FRAME_WIDTH, 640)
capture.set(cv2.CAP_PROP_FRAME_HEIGHT, 480)

#영상출력 반복
while True:
    ret, frame = capture.read() #ret(정상작동여부), frame(현재프레임)
    cv2.imshow("VideoFrame", frame)
    if cv2.waitKey(1) > 0: break

capture.release() #메모리 해제
cv2.destroyAllWindows() #윈도우창 닫기