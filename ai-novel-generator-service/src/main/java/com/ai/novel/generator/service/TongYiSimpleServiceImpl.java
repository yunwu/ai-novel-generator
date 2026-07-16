package com.ai.novel.generator.service;

public class TongYiSimpleServiceImpl extends AbstractTongYiServiceImpl {

    /**
     * 自动注入ChatClient、StreamingChatClient，屏蔽模型调用细节
     */
    private final ChatClient chatClient;

    private final StreamingChatClient streamingChatClient;

    @Autowired
    public TongYiSimpleServiceImpl(ChatClient chatClient, StreamingChatClient streamingChatClient) {
        this.chatClient = chatClient;
        this.streamingChatClient = streamingChatClient;
    }
    /**
     * 具体实现：
     */
    @Override
    public String completion(String message) {
        Prompt prompt = new Prompt(new UserMessage(message));
        return chatClient.call(prompt).getResult().getOutput().getContent();
    }
}
